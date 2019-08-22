# JFunction
JFunction is a library in Java to create MCFunctions.
You can also join our [Discord](https://discord.gg/ux6zzd)

### Why?
- Convert functions to newer versions easily.
- Create complex functions more easily, such as circles.

### How to Use?
You will first have to add [Gson](https://github.com/google/gson) as library.

Create a project that uses JFunction as a library.
Create a function.json file in the src folder:
```json
{
  "id": "testpack",
  "main": "me.foo.bar.Class",
  "author": "Your Name",
  "signature": [
    "############",
    "Made by %author.",
    "############"
  ],
  "description": "Description"
}
```
The required fields are `id`, `main` and `description`.
`main` is the location of the Main class, that extends Core.
`signature` will be used as a header, and `%author` is replaced with the `author` field.

Create your Main class, and make it extend `Core`. You can register your functions in a class that extends FunctionBase.
```java
public class FunctionClass extends Core {
    @Override
    public void onInit() {
		registerFunction(new FunctionTest());
    }
}
```
```java
public class FunctionTest extends FunctionBase {
    @Function(name="circle", type=FunctionType.REPEATING)
    public void particle() {
        for(double theta = 0; theta < 2*Math.PI; theta+=2*Math.PI/50) {
            ParticleCommand cmd = new ParticleCommand(ParticleType.FLAME,
                    new RelativeLocation(Math.sin(theta) * 2, 0, Math.cos(theta) * 2),
                    PositionLocation.ZERO, 0, 1);

            addCommand(new ExecuteCommand.Builder()
                    .withAs(Selector.ALL)
                    .withAt(Selector.EXECUTOR)
                    .build(cmd));
        }
    }
}
```
You have to register your functions in onInit.

You can also change the type of the function, by adding it in the Function annotation.
```java
@Function(name="circle", type=FunctionType.REPEATING)
```
The default type is `SINGLE`, which is required to be ran by a command or another function.
`REPEATING` repeats every tick, and `START` runs on load.

The code provided above will draw a circle at the feet of the player made of flames every tick.

## Note!
You must compile the content of JFunction too.

After you compiled it, just run the jar file, and it will generate the function.
