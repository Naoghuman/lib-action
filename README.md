Lib-Action
===



Intention
---

Lib-Action is a library for `easy` storing and accessing actions ([EventHandler]&lt;[ActionEvent]&gt;) 
in a [JavaFX] &amp; [Maven] desktop application.

Current `version` is `0.4.0` (08.31.2016).



Content
---

* [Examples](#Examples)
    - [ApplicationPresenter#registerOnActionOpenExercise()](#registerOnActionOpenExercise)
    - [IRegisterActions#registerActions()](#registerActions())
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

### ApplicationPresenter#registerOnActionOpenExercise()<a name="registerOnActionOpenExercise" />

This example will show how an `action` will be registered with an `actionId` and 
how to `trigger` the action.  
```java
public class ApplicationPresenter ... {
    // Register an action with the actionId ACTION__APPLICATION__OPEN_EXERCISE
    private void registerOnActionOpenExercise() {
        LoggerFacade.getDefault().debug(this.getClass(), "Register on action open [Exercise]"); // NOI18N
        
        ActionFacade.getDefault().register(
                ACTION__APPLICATION__OPEN_EXERCISE,
                (ActionEvent event) -> {
                    final TransferData transferData = (TransferData) event.getSource();
                    final long exercseId = transferData.getLong();
                    this.onActionOpenExerciseWithId(exercseId);
                });
    }
    ...
    // The above defined action will be executed when a user click the exericse
    // in the navigation.
    private void initializeNavigationTabTopics() {
        lvFoundedNavigationEntities.setOnMouseClicked(event -> {
            if (
                    event.getClickCount() == 2
                    && !lvFoundedNavigationEntities.getSelectionModel().isEmpty()
            ) {
                final TransferData transferData = new TransferData();
                transferData.setActionId(ACTION__APPLICATION__OPEN_EXERCISE);
                
                final NavigationEntity navigationEntity = lvFoundedNavigationEntities.getSelectionModel().getSelectedItem();
                final long exercseId = navigationEntity.getNavigation().getEntityId();
                transferData.setLong(exercseId);
                
                ActionFacade.getDefault().handle(transferData);
            }
        });
        ...
    }
}

public interface IActionConfiguration {
    public static final String ACTION__APPLICATION__OPEN_EXERCISE = "ACTION__APPLICATION__OPEN_EXERCISE"; // NOI18N
    ...
}
```


### IRegisterActions#registerActions()<a name="registerActions()" />

In this example we will see how to use the methode `registerActions()` from the 
Interface `IRegisterActions`.  
```java
public class ApplicationPresenter implements IRegisterActions ... {
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // This method will be executed during the initialization from the class 
        // ApplicationPresenter. So all methods in this method will be registered 
        // during the initialization.
        this.registerActions();
        ...
    }
    ...
    @Override
    public void registerActions() {
        LoggerFacade.getDefault().debug(this.getClass(), "Register actions in [ApplicationPresenter]"); // NOI18N
        
        this.registerOnActionOpenTerm();
        ...
    }
    ...
    private void registerOnActionOpenTerm() {
        LoggerFacade.getDefault().debug(this.getClass(), "Register on action open [Term]"); // NOI18N
        
        ActionFacade.getDefault().register(
                ACTION__APPLICATION__OPEN_TERM,
                (ActionEvent event) -> {
                    final TransferData transferData = (TransferData) event.getSource();
                    final long entityId = transferData.getLong();
                    this.onActionOpenTermWithId(entityId);
                });
    }
}
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
public final class ActionFacade implements ILibAction {
```

```java
/**
 * Returns a singleton instance from the class <code>ActionFacade</code>.
 * 
 * @return a singleton instance from the class <code>ActionFacade</code>.
 */
public static final ActionFacade getDefault() {
    return instance.get();
}
```



### com.github.naoghuman.lib.action.api.ILibAction<a name="ILibAction" />

```java
/**
 * The <code>Interface</code> for the class {@link com.github.naoghuman.lib.action.LibAction}.<br />
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
 * Fire an event with the associated actionId.
 * 
 * @param actionId The actionId which allowed access to the assoziated action.
 */
public void handle(String actionId);
```

```java
/**
 * Fire an event with the associated actionId.
 * <p />
 * Internal the <code>long</code> parameter will be stored in a 
 * {@link com.github.naoghuman.lib.action.api.TransferData}. The data can 
 * be access via:
 * <p />
 * public void handleOnAction(ActionEvent event) {<br />
 * &nbsp;&nbsp;&nbsp;&nbsp;final TransferData transferData = (TransferData) event.getSource();<br />
 * &nbsp;&nbsp;&nbsp;&nbsp;final long data = transferData.getLong();<br />
 * &nbsp;&nbsp;&nbsp;&nbsp;&frasl;&frasl; do anything with the long data<br />
 * }
 * 
 * @param actionId The actionId which allowed access to the assoziated action.
 * @param data The long parameter which should be stored and transfered by this event.
 */
public void handle(String actionId, long data);
```

```java
/**
 * Fire an event with the associated actionId.
 * <p />
 * Internal the <code>Object</code> parameter will be stored in a 
 * {@link com.github.naoghuman.lib.action.api.TransferData}. The data can 
 * be access via:
 * <p />
 * public void handleOnAction(ActionEvent event) {<br />
 * &nbsp;&nbsp;&nbsp;&nbsp;final TransferData transferData = (TransferData) event.getSource();<br />
 * &nbsp;&nbsp;&nbsp;&nbsp;final Object data = transferData.getObject();<br />
 * &nbsp;&nbsp;&nbsp;&nbsp;&frasl;&frasl; do anything with the long data<br />
 * }
 * 
 * @param actionId The actionId which allowed access to the assoziated action.
 * @param data The long parameter which should be stored and transfered by this event.
 */
public void handle(String actionId, Object data);
```

```java
/**
 * Fire an event with the associated actionId defined in the 
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
 * with the associated actionId in the <code>TransferData</code>.<br />
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
 * Checks if the specific actionId is registered.
 * 
 * @param actionId The action which should be check if it exists.
 * @return <code>true</code> if the action is registered, otherwise <code>false</code>.
 */
public Boolean isRegistered(String actionId);
```

```java
/**
 * Register an action with the specific actionId.
 * 
 * @param actionId The actionId which allowed access to the associated action.
 * @param event The assoziated action which should be registered.
 */
public void register(String actionId, EventHandler<ActionEvent> event);
```

```java
/**
 * Remove the action with the specific actionId.
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
 * simple POJO to store optional values in an action.
 * <p>
 * For more information about how to use this class see the second example 
 * (https://github.com/Naoghuman/lib-action#HandleTransferData) in the ReadMe.md.
 *
 * @author Naoghuman
 */
public final class TransferData
```

```java
/**
 * Get a stored {@link java.lang.Boolean} value.
 * 
 * @return The stored <code>Boolean</code> value.
 */
public Boolean getBoolean()
```

```java
/**
 * Set the {@link java.lang.Boolean} value.
 * 
 * @param value The <code>Boolean</code> value.
 */
public void setBoolean(Boolean value)
```

```java
/**
 * Get a stored {@link java.lang.Character} value.
 * 
 * @return The stored <code>Character</code> value.
 */
public Character getCharacter()
```

```java
/**
 * Set a {@link java.lang.Character} value.
 * 
 * @param value The <code>Character</code> value.
 */
public void setCharacter(Character value)
```

```java
/**
 * Get the stored {@link java.lang.Double} value.
 * 
 * @return The stored <code>Double</code> value.
 */
public Double getDouble()
```

```java
/**
 * Set a {@link java.lang.Double} value.
 * 
 * @param value The <code>Double</code> value.
 */
public void setDouble(Double value)
```

```java
/**
 * Get the stored {@link java.lang.Integer} value.
 * 
 * @return The stored <code>Integer</code> value.
 */
public Integer getInteger()
```

```java
/**
 * Set a {@link java.lang.Integer} value.
 * 
 * @param value The <code>Integer</code> value.
 */
public void setInteger(Integer value)
```

```java
/**
 * Get the stored {@link java.lang.Long} value.
 * 
 * @return The stored <code>Long</code> value.
 */
public Long getLong()
```

```java
/**
 * Set a {@link java.lang.Long} value.
 * 
 * @param value The <code>Long</code> value.
 */
public void setLong(Long value)
```

```java
/**
 * Get the stored {@link java.lang.String} value.
 * 
 * @return The stored <code>String</code> value.
 */
public String getString()
```

```java
/**
 * Set a {@link java.lang.String} value.
 * 
 * @param value The <code>String</code> value.
 */
public void setString(String value)
```

```java
/**
 * Get the stored {@link java.lang.Object} value.
 * 
 * @return The stored <code>Object</code> value.
 */
public Object getObject()
```

```java
/**
 * Set a {@link java.lang.Object} value.
 * 
 * @param value The <code>Object</code> value.
 */
public void setObject(Object value)
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
 * Set an <code>actionId</code>.
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
 * Set a <code>responseActionId</code>.
 * 
 * @param responseActionId The <code>responseActionId</code>.
 */
public void setResponseActionKey(String responseActionId)
```



Download<a name="Download" />
---

Current `version` is `0.4.0`. Main points in this release are:
* Deploy the jar files to Maven Central :smiley: .
* Change ActionFacade.INSTANCE to ActionFacade.getDefault() with Optional.

**Maven coordinates**  
In context from a [Maven] project you can use following maven coordinates: 
```xml
<dependencies>
    <dependency>
        <groupId>com.github.naoghuman</groupId>
        <artifactId>lib-action</artifactId>
        <version>0.4.0</version>
    </dependency>
</dependencies>
```

Download:
* [Release v0.4.0 (08.31.2016)]

An overview about all existings releases can be found here:
* [Overview from all releases in Lib-Action]



Requirements<a name="Requirements" />
---

* On your system you need [JRE 8] or [JDK 8] installed.
* The library [Lib-Action-0.4.0.jar](#Installation).

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
[Release v0.4.0 (08.31.2016)]:https://github.com/Naoghuman/lib-action/releases/tag/v0.4.0


