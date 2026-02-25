# Key ML Performance Metrics

## True Positives, True Negatives, False Positives, False Negatives

These are the building blocks of most classification metrics (for **binary classification**):

- **True Positive (TP)** → Model correctly predicts **positive** class (actual positive = predicted positive)
- **True Negative (TN)** → Model correctly predicts **negative** class (actual negative = predicted negative)
- **False Positive (FP)** → Model incorrectly predicts **positive** class (actual negative but predicted positive) — _Type I error_
- **False Negative (FN)** → Model incorrectly predicts **negative** class (actual positive but predicted negative) — _Type II error_

<grok-card data-id="8726d0" data-type="image_card" data-plain-type="render_searched_image"  data-arg-size="LARGE" ></grok-card>

<grok-card data-id="6b64ef" data-type="image_card" data-plain-type="render_searched_image"  data-arg-size="LARGE" ></grok-card>

<grok-card data-id="4f3b3e" data-type="image_card" data-plain-type="render_searched_image"  data-arg-size="LARGE" ></grok-card>

## Confusion Matrix

The confusion matrix organizes TP, TN, FP, FN into a table.

Typical layout (binary case):

|                        | **Actual Positive** | **Actual Negative** |
| ---------------------- | ------------------- | ------------------- |
| **Predicted Positive** | TP                  | FP                  |
| **Predicted Negative** | FN                  | TN                  |

## Classification Metrics

| Metric            | Formula                                         | What it tells you                                           | Range      | When to prioritize                  |
| ----------------- | ----------------------------------------------- | ----------------------------------------------------------- | ---------- | ----------------------------------- |
| **Accuracy**      | (TP + TN) / (TP + TN + FP + FN)                 | Overall fraction of correct predictions                     | 0 to 1     | Balanced classes                    |
| **Precision**     | TP / (TP + FP)                                  | Of all predicted positives, how many are actually positive? | 0 to 1     | Cost of false positives is high     |
| **Recall**        | TP / (TP + FN)                                  | Of all actual positives, how many were caught?              | 0 to 1     | Cost of false negatives is high     |
| **F1 Score**      | 2 × (Precision × Recall) / (Precision + Recall) | Harmonic mean — balances precision and recall               | 0 to 1     | Imbalanced data, need balance       |
| **Log Loss**      | –(1/N) Σ [y log(p) + (1–y) log(1–p)]            | Penalizes confident wrong predictions (probabilistic)       | 0 to ∞     | When using probability outputs      |
| **AUC (ROC-AUC)** | Area under the ROC Curve                        | Ability to rank positives higher than negatives             | 0.5 to 1.0 | Threshold-independent, imbalance OK |

### ROC Curve & AUC

The **ROC curve** plots **True Positive Rate (Recall)** vs **False Positive Rate** at different thresholds.  
**AUC** = probability that a random positive instance is ranked higher than a random negative one.

<grok-card data-id="0b07c0" data-type="image_card" data-plain-type="render_searched_image"  data-arg-size="LARGE" ></grok-card>

<grok-card data-id="46c1da" data-type="image_card" data-plain-type="render_searched_image"  data-arg-size="LARGE" ></grok-card>

## Precision-Recall Trade-off

Precision and Recall are often in tension — improving one usually decreases the other.

<grok-card data-id="2b9995" data-type="image_card" data-plain-type="render_searched_image"  data-arg-size="LARGE" ></grok-card>

## Regression Metrics

| Metric    | Formula                                 | Meaning / Sensitivity                           | Best for                              | Range / Good value    |
| --------- | --------------------------------------- | ----------------------------------------------- | ------------------------------------- | --------------------- |
| **MAE**   | (1/n) Σ \|y – ŷ\|                       | Average absolute error                          | Outliers less impactful               | 0 to ∞ (lower better) |
| **MSE**   | (1/n) Σ (y – ŷ)²                        | Average squared error                           | Penalizes large errors heavily        | 0 to ∞ (lower better) |
| **RMSE**  | √MSE                                    | Square root — same unit as target               | Large errors very costly              | Same unit as target   |
| **RMSLE** | √( (1/n) Σ (log(1 + y) – log(1 + ŷ))² ) | RMSE on log scale — handles large range / zeros | Targets vary over orders of magnitude | 0 to ∞ (lower better) |
| **R²**    | 1 – (SS_res / SS_tot)                   | Proportion of variance explained by model       | How much better than mean predictor   | –∞ to 1 (1 = perfect) |

These cover the core metrics most practitioners use daily.
