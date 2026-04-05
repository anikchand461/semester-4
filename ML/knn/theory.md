# K-Nearest Neighbors (KNN) — Complete Guide

> **A simple, powerful, non-parametric algorithm that classifies a data point based on the majority class of its _k_ closest neighbors.**

---

## How KNN Works

![KNN Overview](1775394885161_k_nearest_neighbors.webp)

KNN makes no assumptions about the underlying data distribution. To classify a new point **Pₜ**, it:

1. Computes the distance from **Pₜ** to every training point
2. Picks the **k** closest neighbors
3. Assigns the **majority class** among those k neighbors

---

## Choosing K — The Inner & Outer Ring

![KNN with k=3 and k=6](1775394885161_1_HmuYl9VQX9pzCL4KLmILrg.png)

The diagram above shows the **same red point** classified differently depending on k:

| k     | Neighbors included | Majority class        | Prediction   |
| ----- | ------------------ | --------------------- | ------------ |
| **3** | 2 yellow, 1 purple | Classe A              | 🟡 Yellow    |
| **6** | 3 yellow, 3 purple | Tie → depends on impl | ⚠️ Ambiguous |

- **Small k** → low bias, high variance (sensitive to noise)
- **Large k** → high bias, low variance (smoother decision boundary)
- **Rule of thumb** → try `k = sqrt(n)` as a starting point, then tune with cross-validation

---

## sklearn Demo

```python
import numpy as np
from sklearn.datasets import load_iris
from sklearn.model_selection import train_test_split
from sklearn.preprocessing import StandardScaler
from sklearn.neighbors import KNeighborsClassifier
from sklearn.metrics import classification_report, confusion_matrix

# --- Load & split data ---
X, y = load_iris(return_X_y=True)
X_train, X_test, y_train, y_test = train_test_split(
    X, y, test_size=0.2, random_state=42
)

# --- Scale features (critical for distance-based models!) ---
scaler = StandardScaler()
X_train = scaler.fit_transform(X_train)
X_test  = scaler.transform(X_test)

# --- Train with Euclidean distance (p=2) ---
knn = KNeighborsClassifier(n_neighbors=5, metric="minkowski", p=2)
knn.fit(X_train, y_train)

# --- Evaluate ---
y_pred = knn.predict(X_test)
print(classification_report(y_test, y_pred, target_names=["setosa", "versicolor", "virginica"]))
print("Confusion Matrix:\n", confusion_matrix(y_test, y_pred))
```

### Switch to Manhattan distance

```python
knn_manhattan = KNeighborsClassifier(n_neighbors=5, metric="minkowski", p=1)
knn_manhattan.fit(X_train, y_train)
print("Manhattan accuracy:", knn_manhattan.score(X_test, y_test))
```

> **`metric="minkowski"` with `p=1` → Manhattan | `p=2` → Euclidean**  
> You can also pass `metric="euclidean"` or `metric="manhattan"` directly.

---

## Distance Functions Explained

### 1. Euclidean Distance (L2)

The straight-line ("as the crow flies") distance between two points.

$$d_E(A, B) = \sqrt{\sum_{i=1}^{n}(A_i - B_i)^2}$$

**Best for:** Continuous features, normally distributed data, when direction matters.

---

### 2. Manhattan Distance (L1)

Distance measured along grid axes — like navigating city blocks.

$$d_M(A, B) = \sum_{i=1}^{n}|A_i - B_i|$$

**Best for:** High-dimensional spaces, sparse features, when outliers are a concern (less sensitive to large differences on a single axis).

---

## Custom KNN Implementation

```python
import numpy as np
from collections import Counter


def euclidean_distance(a: np.ndarray, b: np.ndarray) -> float:
    """Straight-line distance between two points."""
    return np.sqrt(np.sum((a - b) ** 2))


def manhattan_distance(a: np.ndarray, b: np.ndarray) -> float:
    """City-block distance between two points."""
    return np.sum(np.abs(a - b))


class CustomKNN:
    """
    K-Nearest Neighbors classifier from scratch.

    Parameters
    ----------
    k        : int   — number of neighbors
    distance : str   — 'euclidean' or 'manhattan'
    """

    DISTANCE_FUNCTIONS = {
        "euclidean": euclidean_distance,
        "manhattan": manhattan_distance,
    }

    def __init__(self, k: int = 5, distance: str = "euclidean"):
        if distance not in self.DISTANCE_FUNCTIONS:
            raise ValueError(f"distance must be one of {list(self.DISTANCE_FUNCTIONS)}")
        self.k = k
        self.dist_fn = self.DISTANCE_FUNCTIONS[distance]
        self.distance_name = distance

    def fit(self, X: np.ndarray, y: np.ndarray) -> "CustomKNN":
        """KNN is lazy — just store the training data."""
        self.X_train = np.array(X)
        self.y_train = np.array(y)
        return self

    def _predict_one(self, x: np.ndarray) -> int:
        # Compute distances to all training points
        distances = [self.dist_fn(x, x_train) for x_train in self.X_train]

        # Get indices of k nearest neighbors
        k_indices = np.argsort(distances)[: self.k]

        # Majority vote
        k_labels = self.y_train[k_indices]
        return Counter(k_labels).most_common(1)[0][0]

    def predict(self, X: np.ndarray) -> np.ndarray:
        return np.array([self._predict_one(x) for x in X])

    def score(self, X: np.ndarray, y: np.ndarray) -> float:
        return np.mean(self.predict(X) == y)

    def __repr__(self) -> str:
        return f"CustomKNN(k={self.k}, distance='{self.distance_name}')"
```

---

## Side-by-Side Comparison

```python
from sklearn.datasets import load_iris
from sklearn.model_selection import train_test_split
from sklearn.preprocessing import StandardScaler

X, y = load_iris(return_X_y=True)
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)

scaler = StandardScaler()
X_train_s = scaler.fit_transform(X_train)
X_test_s  = scaler.transform(X_test)

results = []
for dist in ["euclidean", "manhattan"]:
    for k in [3, 5, 7]:
        model = CustomKNN(k=k, distance=dist)
        model.fit(X_train_s, y_train)
        acc = model.score(X_test_s, y_test)
        results.append((dist, k, round(acc, 4)))

print(f"{'Distance':<12} {'k':<4} {'Accuracy'}")
print("-" * 28)
for dist, k, acc in results:
    print(f"{dist:<12} {k:<4} {acc}")
```

**Sample output:**

```
Distance     k    Accuracy
----------------------------
euclidean    3    0.9667
euclidean    5    0.9667
euclidean    7    0.9667
manhattan    3    1.0000
manhattan    5    0.9667
manhattan    7    0.9667
```

---

## Euclidean vs Manhattan — When to Use What?

| Scenario                                            | Recommended                   |
| --------------------------------------------------- | ----------------------------- |
| Low-dimensional, continuous features                | ✅ Euclidean                  |
| High-dimensional data (curse of dimensionality)     | ✅ Manhattan                  |
| Features with very different scales (after scaling) | Either — test both            |
| Sparse features / many zeros                        | ✅ Manhattan                  |
| Outliers in data                                    | ✅ Manhattan (less sensitive) |
| Image pixel distances                               | ✅ Euclidean                  |

---

## Key Takeaways

- **Always scale your features** before using KNN — distances are meaningless otherwise
- **KNN is lazy** (no training phase) but expensive at inference O(n·d) per query
- **Tune k** using cross-validation, not gut feeling
- **Euclidean** works best when the feature space is isotropic and low-dimensional
- **Manhattan** tends to outperform in high dimensions or sparse settings
- Use `sklearn` for production; the custom implementation above is for learning the internals

---

_Written with 💛 — KNN is simple, but understanding the distance metric is what separates good usage from great usage._
