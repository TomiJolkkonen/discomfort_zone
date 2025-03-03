
# Deep Learning with Python - Practical Cheat Sheet

## 1. Model Building in Keras

### Sequential Model
```python
from tensorflow import keras
from tensorflow.keras import layers

model = keras.Sequential([
    layers.Dense(64, activation="relu"),
    layers.Dense(10, activation="softmax")
])
```

### Functional API
```python
inputs = keras.Input(shape=(3,))
x = layers.Dense(64, activation="relu")(inputs)
outputs = layers.Dense(10, activation="softmax")(x)
model = keras.Model(inputs=inputs, outputs=outputs)
```

### Model Subclassing
```python
class MyModel(keras.Model):
    def __init__(self):
        super().__init__()
        self.dense1 = layers.Dense(64, activation="relu")
        self.dense2 = layers.Dense(10, activation="softmax")

    def call(self, inputs):
        x = self.dense1(inputs)
        return self.dense2(x)

model = MyModel()
```

## 2. Regularization
### L2 Regularization
```python
from tensorflow.keras import regularizers
layers.Dense(16, kernel_regularizer=regularizers.l2(0.002))
```

### Dropout
```python
layers.Dropout(0.5)
```

## 3. Callbacks
```python
callbacks = [
    keras.callbacks.EarlyStopping(monitor="val_loss", patience=2),
    keras.callbacks.ModelCheckpoint(filepath="best_model.keras", save_best_only=True)
]
```

## 4. Training
### Using `fit()`
```python
model.compile(optimizer="rmsprop", loss="binary_crossentropy", metrics=["accuracy"])
model.fit(train_data, train_labels, epochs=20, batch_size=512, validation_split=0.4)
```

### Custom Training Step
```python
class CustomModel(keras.Model):
    def train_step(self, data):
        x, y = data
        with tf.GradientTape() as tape:
            y_pred = self(x, training=True)
            loss = self.compiled_loss(y, y_pred)
        gradients = tape.gradient(loss, self.trainable_variables)
        self.optimizer.apply_gradients(zip(gradients, self.trainable_variables))
        self.compiled_metrics.update_state(y, y_pred)
        return {m.name: m.result() for m in self.metrics}
```

## 5. TensorBoard
```python
tensorboard_cb = keras.callbacks.TensorBoard(log_dir="./logs")
model.fit(train_data, train_labels, epochs=10, callbacks=[tensorboard_cb])
```

## 6. Metrics
```python
accuracy = keras.metrics.SparseCategoricalAccuracy()
accuracy.update_state(y_true, y_pred)
result = accuracy.result().numpy()
```

## 7. Saving and Loading Models
```python
model.save('my_model.keras')
model = keras.models.load_model('my_model.keras')
```

## 8. Optimizers
```python
optimizer = keras.optimizers.RMSprop(learning_rate=0.001)
```

## 9. Early Stopping
```python
early_stop = keras.callbacks.EarlyStopping(monitor='val_loss', patience=3)
```

---
This cheat sheet is a quick reference for practical coding with Keras in TensorFlow.
