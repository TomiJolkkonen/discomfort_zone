# Deep Learning Cheat Sheet

## Basics
- **Deep Learning**: A subset of machine learning using neural networks with multiple layers.
- **Neural Network**: A system of layers (input, hidden, output) that process data through weighted connections.

## Libraries & Frameworks
- `TensorFlow` - Open-source library for deep learning.
- `Keras` - High-level API for TensorFlow.
- `PyTorch` - Flexible deep learning framework.
- `Scikit-learn` - For traditional ML models and preprocessing.

## Neural Network Components
- **Layers**: 
  - `Dense(units, activation='relu')` - Fully connected layer.
  - `Conv2D(filters, kernel_size, activation='relu')` - Convolutional layer (CNNs).
  - `LSTM(units)` - Long Short-Term Memory layer (RNNs).
- **Activation Functions**:
  - `relu` - Rectified Linear Unit (default for hidden layers).
  - `sigmoid` - Output in range (0,1) (useful for binary classification).
  - `softmax` - Converts outputs into probability distribution (multi-class classification).

## Model Building with Keras
```python
import tensorflow as tf
from tensorflow import keras

model = keras.Sequential([
    keras.layers.Dense(128, activation='relu', input_shape=(input_dim,)),
    keras.layers.Dense(64, activation='relu'),
    keras.layers.Dense(output_dim, activation='softmax')
])

model.compile(optimizer='adam', loss='categorical_crossentropy', metrics=['accuracy'])
model.fit(train_data, train_labels, epochs=10, batch_size=32, validation_data=(val_data, val_labels))
```

## Optimization
- `SGD(lr=0.01, momentum=0.9)` - Stochastic Gradient Descent.
- `Adam(lr=0.001)` - Adaptive Moment Estimation (default choice).
- `RMSprop(lr=0.001)` - Root Mean Square Propagation (useful for RNNs).

## Regularization Techniques
- **Dropout**: `Dropout(rate=0.5)` - Prevents overfitting by randomly dropping units.
- **L2 Regularization**: `Dense(64, kernel_regularizer=keras.regularizers.l2(0.01))`.
- **Batch Normalization**: `BatchNormalization()` - Normalizes activations.

## CNNs for Image Processing
```python
model = keras.Sequential([
    keras.layers.Conv2D(32, (3,3), activation='relu', input_shape=(64, 64, 3)),
    keras.layers.MaxPooling2D(2,2),
    keras.layers.Flatten(),
    keras.layers.Dense(128, activation='relu'),
    keras.layers.Dense(10, activation='softmax')
])
```

## RNNs & LSTMs for Time Series
```python
model = keras.Sequential([
    keras.layers.LSTM(50, return_sequences=True, input_shape=(timesteps, features)),
    keras.layers.LSTM(50),
    keras.layers.Dense(1)
])
```

## Transformer Model (Simplified)
```python
transformer = keras.models.Sequential([
    keras.layers.Embedding(input_dim=5000, output_dim=128),
    keras.layers.Attention(),
    keras.layers.Dense(64, activation='relu'),
    keras.layers.Dense(1, activation='sigmoid')
])
```

## Generative Models
- **GANs**: Generate synthetic data.
- **VAEs**: Variational Autoencoders for generating similar data.

## Best Practices
- Normalize data using `StandardScaler()`.
- Use early stopping: `EarlyStopping(monitor='val_loss', patience=5)`.
- Save models using `model.save('model.h5')`.

---
This cheat sheet provides a concise reference for deep learning essentials.
