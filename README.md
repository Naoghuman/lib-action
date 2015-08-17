Lib-Action
===============



Intention
---------

A library for `easy` storing and accessing actions ([EventHandler]&lt;[ActionEvent]&gt;) 
in a [JavaFX] &amp; [Maven] desktop application.

Current `version` is `0.2.0` (07.2015).



Content
-------

* [Examples](#Examples)
    - [registerOnActionOpenDream()](#RegisterOnActionOpenDream)
    - [handle(ActionTransferModel model)](#HandleActionTransferModel)
* [Api](#Api)
    - [de.pro.lib.action.api.ActionFacade](#ActionFacade)
    - [de.pro.lib.action.api.ActionTransferModel](#ActionTransferModel)
* [Requirements](#Requirements)
* [Installation](#Installation)
* [Documentation](#Documentation)
* [Contribution](#Contribution)
* [License](#License)
* [Autor](#Autor)
* [Contact](#Contact)



Examples<a name="Examples" />
-------

### registerOnActionOpenDream()<a name="RegisterOnActionOpenDream" />

Here you can see an example how to define an action
```java
public void registerOnActionOpenDream() {
    ActionFacade.INSTANCE.register(
            ACTION__OPEN_DREAM__FROM_NAVIGATION,
            (ActionEvent ae) -> {
                final ActionTransferModel model = (ActionTransferModel) ae.getSource();
                this.show(model.getLong());
            });
}
```


### handle(ActionTransferModel model)<a name="HandleActionTransferModel" />

and how the above defined action is fired.
```java
final ActionTransferModel model = new ActionTransferModel();
model.setActionKey(ACTION__OPEN_DREAM__FROM_NAVIGATION);
model.setLong(idToOpen);

ActionFacade.INSTANCE.handle(model);
```



Api<a name="Api" />
-------

### de.pro.lib.action.api.ActionFacade<a name="ActionFacade" />

```java
/**
 * The facade {@link de.pro.lib.action.api.ActionFacade} provides access to
 * the action methods during the Interface {@link de.pro.lib.action.api.ILibAction}.
 *
 * @author PRo
 * @see de.pro.lib.action.api.ILibAction
 */
public enum ActionFacade implements ILibAction
```

```java
/**
 * Fire an event with the associated actionKey.
 * 
 * @param actionKey The key which allowed access to the associated action.
 */
ActionFacade.INSTANCE.handle(String actionKey);
```

```java
/**
 * Fire an event with the associated actionKey defined in the 
 * {@link de.pro.lib.action.api.ActionTransferModel}.<br />
 * 
 * The {@link de.pro.lib.action.api.ActionTransferModel} will be stored in 
 * the action event and can reached over <code>event.getSource(): Object</code> 
 * in the overriden {@link javafx.event.ActionEvent}.
 * 
 * @param model A <code>ActionTransferModel</code> which contains the actionKey and additional parameters.
 */
ActionFacade.INSTANCE.handle(ActionTransferModel model);
```

```java
/**
 * Fire an event for every {@link de.pro.lib.action.api.ActionTransferModel} 
 * with the associated actionKey in the model.<br />
 * 
 * The {@link de.pro.lib.action.api.ActionTransferModel} will be stored in 
 * the action event and can reached over <code>event.getSource(): Object</code> 
 * in the overriden {@link javafx.event.ActionEvent}.
 * 
 * @param models A List with <code>ActionTransferModel</code> which contains the actionKeys and additional parameters.
 */
ActionFacade.INSTANCE.handle(List<ActionTransferModel> models);
```

```java
/**
 * Checks if the specific action key is registered.
 * 
 * @param actionKey The action which should be check if it exists.
 * @return <code>true</code> if the action is registered, otherwise <code>false</code>.
 */
ActionFacade.INSTANCE.isRegistered(String actionKey);
```

```java
/**
 * Register an action with the specific key.
 * 
 * @param actionKey The key which allowed access to the associated action.
 * @param action The action which should be registered.
 */
ActionFacade.INSTANCE.register(String actionKey, EventHandler<ActionEvent> action);
```

```java
/**
 * Remove the action with the specific key.
 * 
 * @param actionKey The action which should be removed.
 */
ActionFacade.INSTANCE.remove(String actionKey);
```


### de.pro.lib.action.api.ActionTransferModel<a name="ActionTransferModel" />

```java
/**
 * Get the stored {@link java.lang.Boolean} parameter.
 * 
 * @return The stored <code>Boolean</code> parameter.
 */
public Boolean getBoolean()
```

```java
/**
 * Set the {@link java.lang.Boolean} parameter.
 * 
 * @param booleanParameter The <code>Boolean</code> parameter.
 */
public void setBoolean(Boolean booleanParameter)
```

```java
/**
 * Get the stored {@link java.lang.Double} parameter.
 * 
 * @return The stored <code>Double</code> parameter.
 */
public Double getDouble()
```

```java
/**
 * Set the {@link java.lang.Double} parameter.
 * 
 * @param doubleParameter The <code>Double</code> parameter.
 */
public void setDouble(Double doubleParameter)
```

```java
/**
 * Get the stored {@link java.lang.Integer} parameter.
 * 
 * @return The stored <code>Integer</code> parameter.
 */
public Integer getInteger()
```

```java
/**
 * Set the {@link java.lang.Integer} parameter.
 * 
 * @param integerParameter The <code>Integer</code> parameter.
 */
public void setInteger(Integer integerParameter)
```

```java
/**
 * Get the stored {@link java.lang.Long} parameter.
 * 
 * @return The stored <code>Long</code> parameter.
 */
public Long getLong()
```

```java
/**
 * Set the {@link java.lang.Long} parameter.
 * 
 * @param longParameter The <code>Long</code> parameter.
 */
public void setLong(Long longParameter)
```

```java
/**
 * Get the stored {@link java.lang.String} parameter.
 * 
 * @return The stored <code>String</code> parameter.
 */
public String getString()
```

```java
/**
 * Set the {@link java.lang.String} parameter.
 * 
 * @param stringParameter The <code>String</code> parameter.
 */
public void setString(String stringParameter)
```

```java
/**
 * Get the stored {@link java.lang.Object} parameter.
 * 
 * @return The stored <code>Object</code> parameter.
 */
public Object getObject()
```

```java
/**
 * Set the {@link java.lang.Object} parameter.
 * 
 * @param objectParameter The <code>Object</code> parameter.
 */
public void setObject(Object objectParameter)
```

```java
/**
 * Get the <code>action key</code>.
 * 
 * @return The <code>action key</code>.
 */
public String getActionKey()
```

```java
/**
 * Set the <code>action key</code>.
 * 
 * @param actionKey The <code>action key</code>.
 */
public void setActionKey(String actionKey)
```

```java
/**
 * Get the <code>responce action key</code>.
 * 
 * @return The <code>responce action key</code>.
 */
public String getResponseActionKey()
```

```java
/**
 * Set the <code>responce action key</code>.
 * 
 * @param responseActionKey The <code>responce action key</code>.
 */
public void setResponseActionKey(String responseActionKey)
```


Requirements<a name="Requirements" />
------------

* On your system you need [JRE 8] or [JDK 8] installed.
* The library [Lib-Action-0.2.0.jar](#Installation).
* The library [Lib-Logger-0.2.0.jar](#Installation).
  * Included is the [log4j-api-2.3.jar].
  * Included is the [log4j-core-2.3.jar].



Installation<a name="Installation" />
------------

* If not installed download the [JRE 8] or the [JDK 8].
  * Optional: To work better with [FXML] files in a [JavaFX] application download the [JavaFX Scene Builder] under 'Additional Resources'.
* Choose your preferred IDE (e.g. [NetBeans], [Eclipse] or [IntelliJ IDEA]) for development.
* Download or clone [Lib-Action].
* Download or clone [Lib-Logger].
* Open the projects in your IDE and run them.



Documentation<a name="Documentation" />
-------------

Momentary only the [JavaDoc] in the library itself is available.



Contribution<a name="Contribution" />
------------

* If you find a `Bug` I will be glad if you could report an [Issue].
* If you want to contribute to the project plz fork the project and do a [Pull Request].



License<a name="License" />
-------

The project `Lib-Action` is licensed under [General Public License 3.0].



Autor<a name="Autor" />
-----

The project `Lib-Action` is maintained by me, Peter Rogge. See [Contact](#Contact).



Contact<a name="Contact" />
-------

You can reach me under <peter.rogge@yahoo.de>.


[//]: # (Links)
[ActionEvent]:http://docs.oracle.com/javase/8/javafx/api/javafx/event/ActionEvent.html
[Eclipse]:https://www.eclipse.org/
[EventHandler]:http://docs.oracle.com/javase/8/javafx/api/javafx/event/EventHandler.html
[FXML]:http://docs.oracle.com/javafx/2/fxml_get_started/jfxpub-fxml_get_started.htm
[General Public License 3.0]:http://www.gnu.org/licenses/gpl-3.0.en.html
[IntelliJ IDEA]:http://www.jetbrains.com/idea/
[Issue]:https://github.com/Naoghuman/lib-action/issues
[JavaDoc]:http://www.oracle.com/technetwork/java/javase/documentation/index-jsp-135444.html
[JavaFX]:http://docs.oracle.com/javase/8/javase-clienttechnologies.htm
[JavaFX Scene Builder]:http://www.oracle.com/technetwork/java/javase/downloads/index.html
[JDK 8]:http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
[JRE 8]:http://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html
[Lib-Action]:https://github.com/Naoghuman/lib-action
[Lib-Logger]:https://github.com/Naoghuman/lib-logger
[log4j-api-2.3.jar]:https://logging.apache.org/log4j/2.0/log4j-web/dependencies.html
[log4j-core-2.3.jar]:https://logging.apache.org/log4j/2.0/log4j-web/dependencies.html
[Maven]:http://maven.apache.org/
[NetBeans]:https://netbeans.org/
[Pull Request]:https://help.github.com/articles/using-pull-requests


