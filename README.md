Lib-Action
===



Intention
---

Lib-Action is a library for `easy` storing and accessing actions ([EventHandler]&lt;[ActionEvent]&gt;) 
in a [JavaFX] &amp; [Maven] desktop application.

Current `version` is `0.2.2` (09.2015).



Content
---

* [Examples](#Examples)
    - TODO UPDATE [registerOnActionOpenDream()](#RegisterOnActionOpenDream)
    - TODO UPDATE [handle(ActionTransferModel model)](#HandleActionTransferModel)
* [Api](#Api)
    - [com.github.naoghuman.lib.action.api.ActionFacade](#ActionFacade)
    - [com.github.naoghuman.lib.action.api.ILibAction](#ILibAction)
    - [com.github.naoghuman.lib.action.api.IRegisterActions](#IRegisterActions)
    - [com.github.naoghuman.lib.action.api.TransferData](#TransferData)
* [Download](#Download)
* [Requirements](#Requirements)
* [Installation](#Installation)
* [Documentation](#Documentation)
* [Contribution](#Contribution)
* [License](#License)
* [Autor](#Autor)
* [Contact](#Contact)



Examples<a name="Examples" />
---

### registerOnActionOpenDream()<a name="RegisterOnActionOpenDream" />

TODO UPDATE Here you can see an example how to define an action
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

TODO UPDATE and how the above defined action is fired.
```java
final ActionTransferModel model = new ActionTransferModel();
model.setActionKey(ACTION__OPEN_DREAM__FROM_NAVIGATION);
model.setLong(idToOpen);

ActionFacade.INSTANCE.handle(model);
```



Api<a name="Api" />
---

### com.github.naoghuman.lib.action.api.ActionFacade<a name="ActionFacade" />

```java
/**
 * The facade {@link com.github.naoghuman.lib.action.api.ActionFacade} provides 
 * access to the action methods during the Interface 
 * {@link com.github.naoghuman.lib.action.api.ILibAction}.
 *
 * @author Naoghuman
 * @see com.github.naoghuman.lib.action.api.ILibAction
 */
public enum ActionFacade implements ILibAction
```

```java
/**
 * Over the value <code>INSTANCE</code> the developer have access to the
 * functionality in the enum <code>ActionFacade</code>.
 */
INSTANCE;
```



### com.github.naoghuman.lib.action.api.ILibAction<a name="ILibAction" />

```java
/**
 * The <code>Interface</code> for the class {@link de.pro.lib.action.LibAction}.<br />
 * Over the facade {@link com.github.naoghuman.lib.action.api.ActionFacade} you 
 * can access the methods in this <code>Interface</code>.
 *
 * @author Naoghuman
 * @see com.github.naoghuman.lib.action.LibAction
 * @see com.github.naoghuman.lib.action.api.ActionFacade
 */
public interface ILibAction
```

```java
/**
 * Fire an event with the associated actionKey.
 * 
 * @param actionId The actionId which allowed access to the assoziated action.
 */
public void handle(String actionId);
```

```java
/**
 * Fire an event with the associated actionKey defined in the 
 * {@link com.github.naoghuman.lib.action.api.TransferData}.<br />
 * 
 * The {@link com.github.naoghuman.lib.action.api.TransferData} will be 
 * stored in the action event and can reached over <code>event.getSource(): Object</code> 
 * in the overriden {@link javafx.event.ActionEvent}.
 * 
 * @param transferData A <code>TransferData</code> which contains the actionId and additional parameters.
 */
public void handle(TransferData transferData);
```

```java
/**
 * Fire an event for every {@link com.github.naoghuman.lib.action.api.TransferData} 
 * with the associated actionKey in the model.<br />
 * 
 * The {@link com.github.naoghuman.lib.action.api.TransferData} will be stored in 
 * the action event and can reached over <code>event.getSource(): Object</code> 
 * in the overriden {@link javafx.event.ActionEvent}.
 * 
 * @param transferDatas A List with <code>TransferData</code> which contains the actionIds and additional parameters.
 */
public void handle(List<TransferData> transferDatas);
```

```java
/**
 * Checks if the specific action key is registered.
 * 
 * @param actionId The action which should be check if it exists.
 * @return <code>true</code> if the action is registered, otherwise <code>false</code>.
 */
public Boolean isRegistered(String actionId);
```

```java
/**
 * Register an action with the specific id.
 * 
 * @param actionId The actionId which allowed access to the associated action.
 * @param event The assoziated action which should be registered.
 */
public void register(String actionId, EventHandler<ActionEvent> event);
```

```java
/**
 * Remove the action with the specific id.
 * 
 * @param actionId The assoziated action which should be removed.
 */
public void remove(String actionId);
```


### com.github.naoghuman.lib.action.api.IRegisterActions<a name="IRegisterActions" />

```java
/**
 * Over this interface the developer can <code>register</code> 
 * {@link javafx.event.ActionEvent}s during the method
 * {@link com.github.naoghuman.lib.action.LibAction#register(java.lang.String, javafx.event.EventHandler) }.
 * 
 * @author Naoghuman
 * @see com.github.naoghuman.lib.action.LibAction#register(java.lang.String, javafx.event.EventHandler)
 * @see javafx.event.ActionEvent
 */
public interface IRegisterActions
```

```java
/**
 * Implementing this method alloweds <code>register</code>
 * {@link javafx.event.ActionEvent}s during the method
 * {@link com.github.naoghuman.lib.action.LibAction#register(java.lang.String, javafx.event.EventHandler) }.
 * 
 * @see com.github.naoghuman.lib.action.LibAction#register(java.lang.String, javafx.event.EventHandler)
 * @see javafx.event.ActionEvent
 */
public void registerActions();
```


### com.github.naoghuman.lib.action.api.TransferData<a name="TransferData" />

```java
/**
 * The class {@link com.github.naoghuman.lib.action.api.TransferData} is a 
 * simple POJO to store optional parameters in an action.
 * <p>
 * For more information see the ReadMe.md (at the end of the section examples).
 *
 * @author Naoghuman
 */
public class TransferData
```

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
 * Get the stored {@link java.lang.Character} parameter.
 * 
 * @return The stored <code>Character</code> parameter.
 */
public Character getCharacter()
```

```java
/**
 * Set the {@link java.lang.Character} parameter.
 * 
 * @param characterParameter The <code>Character</code> parameter.
 */
public void setCharacter(Character characterParameter)
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
 * Get the <code>actionId</code>.
 * 
 * @return The <code>actionId</code>.
 */
public String getActionId()
```

```java
/**
 * Set the <code>actionId</code>.
 * 
 * @param actionId The <code>actionId</code>.
 */
public void setActionId(String actionId)
```

```java
/**
 * Get the <code>responseActionId</code>.
 * 
 * @return The <code>responseActionId</code>.
 */
public String getResponseActionId()
```

```java
/**
 * Set the <code>responseActionId</code>.
 * 
 * @param responseActionId The <code>responseActionId</code>.
 */
public void setResponseActionKey(String responseActionId)
```



Download<a name="Download" />
---

Current `version` is `0.2.2`. Main points in this release are:
* Fix missing update from the library Lib-Logger to v0.2.1 in sourcecode.

Download:
* [Release v0.2.2 (09.2015)]

An overview about all existings releases can be found here:
* [Overview from all releases in Lib-Action]



Requirements<a name="Requirements" />
---

* On your system you need [JRE 8] or [JDK 8] installed.
* The library [Lib-Action-0.2.2.jar](#Installation).

In the library are following libraries registered as dependencies:
* The library [Lib-Logger-0.4.0.jar](#Installation).
  * Included in `Lib-Logger` is the [log4j-api-2.6.2.jar].
  * Included in `Lib-Logger` is the [log4j-core-2.6.2.jar].



Installation<a name="Installation" />
---

##### Install the project in your preferred IDE

* If not installed download the [JRE 8] or the [JDK 8].
    - Optional: To work better with [FXML] files in a [JavaFX] application 
      download the [JavaFX Scene Builder] under 'Additional Resources'.
* Choose your preferred IDE (e.g. [NetBeans], [Eclipse] or [IntelliJ IDEA]) for development.
* Download or clone [Lib-Action].
* Download or clone [Lib-Logger].
* Open the projects in your IDE and run them.



Documentation<a name="Documentation" />
---

* In section [Api](#Api) you can see the main point(s) to access the functionality 
  in this library.
* For additional information see the [JavaDoc] in the library itself.



Contribution<a name="Contribution" />
---

* If you find a `Bug` I will be glad if you could report an [Issue].
* If you want to contribute to the project plz fork the project and do a [Pull Request].



License<a name="License" />
---

The project `Lib-Action` is licensed under [General Public License 3.0].



Autor<a name="Autor" />
---

The project `Lib-Action` is maintained by me, Peter Rogge. See [Contact](#Contact).



Contact<a name="Contact" />
---

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
[log4j-api-2.6.2.jar]:https://logging.apache.org/log4j/2.0/log4j-web/dependencies.html
[log4j-core-2.6.2.jar]:https://logging.apache.org/log4j/2.0/log4j-web/dependencies.html
[Maven]:http://maven.apache.org/
[NetBeans]:https://netbeans.org/
[Overview from all releases in Lib-Action]:https://github.com/Naoghuman/lib-action/releases
[Pull Request]:https://help.github.com/articles/using-pull-requests
[Release v0.2.2 (09.2015)]:https://github.com/Naoghuman/lib-action/releases/tag/v0.2.2


