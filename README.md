Lib-Action
===



Intention
---

Lib-Action is a library for `easy` storing and accessing actions ([EventHandler]&lt;[ActionEvent]&gt;) 
in a [JavaFX] &amp; [Maven] desktop application.

Current `version` is `0.4.1` (05.21.2017).



Content
---

* [Examples](#Examples)
    - [ApplicationPresenter#registerOnActionOpenExercise()](#registerOnActionOpenExercise)
    - [IRegisterActions#registerActions()](#registerActions())
* [Api](#Api)
    - [com.github.naoghuman.lib.action.core.ActionFacade](#AcFa)
    - [com.github.naoghuman.lib.action.core.ActionHandler](#AcHa)
    - [com.github.naoghuman.lib.action.core.RegisterActions](#ReAc)
    - [com.github.naoghuman.lib.action.core.TransferData](#TrDa)
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

### com.github.naoghuman.lib.action.core.ActionFacade<a name="AcFa" />

```java
/**
 * The facade {@link com.github.naoghuman.lib.action.core.ActionFacade} provides 
 * access to the action methods in the <code>Interface</code> 
 * {@link com.github.naoghuman.lib.action.core.ActionHandler}.
 *
 * @author Naoghuman
 * @see com.github.naoghuman.lib.action.core.ActionHandler
 */
public final class ActionFacade implements ActionHandler {
```

```java
/**
 * Returns a singleton instance from the class <code>ActionFacade</code>.
 * 
 * @return a singleton instance from the class <code>ActionFacade</code>.
 */
public static final ActionFacade getDefault()
```


### com.github.naoghuman.lib.action.core.ActionHandler<a name="AcHa" />

```java
/**
 * The <code>Interface</code> for the class {@link com.github.naoghuman.lib.action.internal.DefaultActionHandler}.<br>
 * Over the facade {@link com.github.naoghuman.lib.action.core.ActionFacade} you 
 * can access the methods in this <code>Interface</code>.
 *
 * @author Naoghuman
 * @see com.github.naoghuman.lib.action.core.ActionFacade
 * @see com.github.naoghuman.lib.action.internal.DefaultActionHandler
 */
public interface ActionHandler {
```

```java
/**
 * Fires an {@link javafx.event.ActionEvent} with the associated actionId.
 * <p>
 * <b>Hint:</b><br>
 * The <code>actionId</code> and its associated {@link javafx.event.EventHandler} 
 * must before registered during the method 
 * {@link com.github.naoghuman.lib.action.core.ActionHandler#register(java.lang.String, javafx.event.EventHandler)}.
 * 
 * @param actionId The actionId which allowed access to the assoziated action.
 * @see            com.github.naoghuman.lib.action.core.ActionHandler#register(java.lang.String, javafx.event.EventHandler) 
 * @see            javafx.event.ActionEvent
 * @see            javafx.event.EventHandler
 */
public void handle(final String actionId);
```

```java
/**
 * Fires an {@link javafx.event.ActionEvent} with the associated actionId and 
 * the given parameter <code>value</code>.
 * <p>
 * Internal the parameter <code>data</code> will be stored in a 
 * {@link com.github.naoghuman.lib.action.api.TransferData}. The data can 
 * be access via:<br>
 * public void handleOnAction(ActionEvent event) {<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;final TransferData transferData = (TransferData) event.getSource();<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;final long data = transferData.getLong();<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;&frasl; &frasl; do anything with the data<br>
 * }
 * <p>
 * <b>Hint:</b><br>
 * The <code>actionId</code> and its associated {@link javafx.event.EventHandler} 
 * must before registered during the method 
 * {@link com.github.naoghuman.lib.action.core.ActionHandler#register(java.lang.String, javafx.event.EventHandler)}.
 * 
 * @param actionId The actionId which allowed access to the assoziated action.
 * @param value    The long parameter which should be stored and transfered by this event.
 * @see            com.github.naoghuman.lib.action.core.ActionHandler#register(java.lang.String, javafx.event.EventHandler)
 * @see            com.github.naoghuman.lib.action.core.TransferData
 * @see            javafx.event.ActionEvent
 * @see            javafx.event.EventHandler
 */
public void handle(String actionId, long value);
```

```java
/**
 * Fires an {@link javafx.event.ActionEvent} with the associated actionId defined in 
 * the {@link com.github.naoghuman.lib.action.core.TransferData}.
 * <p>
 * The {@link com.github.naoghuman.lib.action.core.TransferData} will be 
 * stored in the executed <code>ActionEvent</code> and can reached with the
 * method <code>event.getSource(): Object</code> in the overriden <code>ActionEvent</code>.
 * <p>
 * <b>Hint:</b><br>
 * The <code>actionId</code> and its associated {@link javafx.event.EventHandler} 
 * must before registered during the method 
 * {@link com.github.naoghuman.lib.action.core.ActionHandler#register(java.lang.String, javafx.event.EventHandler)}.
 * 
 * @param transferData A <code>TransferData</code> which contains the actionId and additional parameters.
 * @see                com.github.naoghuman.lib.action.core.ActionHandler#register(java.lang.String, javafx.event.EventHandler)
 * @see                com.github.naoghuman.lib.action.core.TransferData
 * @see                javafx.event.ActionEvent
 * @see                javafx.event.EventHandler
 */
public void handle(final TransferData transferData);
```

```java
/**
 * Fires an {@link javafx.event.ActionEvent} for every {@link com.github.naoghuman.lib.action.core.TransferData} 
 * with the associated <code>actionId</code> in the specific <code>TransferData</code>.
 * <p>
 * The {@link com.github.naoghuman.lib.action.core.TransferData} will be 
 * stored in the executed <code>ActionEvent</code> and can reached with the
 * method <code>event.getSource(): Object</code> in the overriden <code>ActionEvent</code>.
 * <p>
 * <b>Hint:</b><br>
 * All <code>actionIds</code> and its associated {@link javafx.event.EventHandler} 
 * must before registered during the method 
 * {@link com.github.naoghuman.lib.action.core.ActionHandler#register(java.lang.String, javafx.event.EventHandler)}.
 * 
 * @param transferDatas A List with <code>TransferData</code> which contains the actionIds and additional parameters.
 * @see                 com.github.naoghuman.lib.action.core.ActionHandler#register(java.lang.String, javafx.event.EventHandler)
 * @see                 com.github.naoghuman.lib.action.core.TransferData
 * @see                 javafx.event.ActionEvent
 * @see                 javafx.event.EventHandler
 */
public void handle(final ObservableList<TransferData> transferDatas);
```

```java
/**
 * Checks if the specific <code>actionId</code> is registered.
 * 
 * @param actionId The actionId which should be check if it is exists.
 * @return         <code>true</code> if the actionId (with associated EventHandler) 
 *                 is registered, otherwise <code>false</code>.
 */
public boolean isRegistered(final String actionId);
```

```java
/**
 * Register an {@link javafx.event.EventHandler} with the specific <code>actionId</code>.
 * 
 * @param actionId     The actionId which allowed access to the associated EventHandler.
 * @param eventHandler The assoziated EventHandler which should be registered.
 * @return             <code>true</code> if the EventHandler is registered, otherwise <code>false</code>.
 * @see                javafx.event.EventHandler
 */
public boolean register(final String actionId, final EventHandler<ActionEvent> eventHandler);
```

```java
/**
 * Removes the {@link javafx.event.EventHandler} with the specific specific 
 * <code>actionId</code>.
 * 
 * @param actionId The actionId which should be removed with the associated EventHandler.
 * @return         <code>true</code> if the EventHandler is removed, otherwise <code>false</code>.
 * @see            javafx.event.EventHandler
 */
public boolean remove(final String actionId);
```


### com.github.naoghuman.lib.action.core.RegisterActions<a name="ReAc" />

```java
/**
 * With this interface the developer have an <code>official</code> method to register all this methods in 
 * the implementing classes which will <code>register</code> {@link javafx.event.ActionEvent}s during the method
 * {@link com.github.naoghuman.lib.action.core.ActionHandler#register(java.lang.String, javafx.event.EventHandler) }
 * with an specific <code>actionId</code>.
 * 
 * @author Naoghuman
 * @see com.github.naoghuman.lib.action.core.ActionHandler#register(java.lang.String, javafx.event.EventHandler)
 * @see javafx.event.ActionEvent
 */
public interface RegisterActions {
```

```java
/**
 * Implementing this method alloweds the developer to <code>register</code> all methods in the 
 * implementing class which will <code>register</code> {@link javafx.event.ActionEvent}s during the method
 * {@link com.github.naoghuman.lib.action.core.ActionHandler#register(java.lang.String, javafx.event.EventHandler) }.
 * 
 * @see com.github.naoghuman.lib.action.core.ActionHandler#register(java.lang.String, javafx.event.EventHandler)
 * @see javafx.event.ActionEvent
 */
public void register();
```


### com.github.naoghuman.lib.action.core.TransferData<a name="TrDa" />

```java
/**
 * The class {@link com.github.naoghuman.lib.action.core.TransferData} is a 
 * simple POJO to store optional values in an {@link javafx.event.ActionEvent}.
 * <p>
 * For more information about how to use this class see the second example 
 * (https://github.com/Naoghuman/lib-action#HandleTransferData) in the ReadMe.md.
 *
 * @author Naoghuman
 * @see    javafx.event.ActionEvent
 */
public final class TransferData {
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
public void setResponseActionId(String responseActionId)
```



Download<a name="Download" />
---

Current `version` is `0.4.1`. Main points in this release are:
* This is a minor update.
* Update the `examples` in the ReadMe.
* Update the JavaDoc from the class `TransferData`.

**Maven coordinates**  
In context from a [Maven] project you can use following maven coordinates: 
```xml
<dependencies>
    <dependency>
        <groupId>com.github.naoghuman</groupId>
        <artifactId>lib-action</artifactId>
        <version>0.4.1</version>
    </dependency>
</dependencies>
```

Download:
* [Release v0.4.1 (05.21.2017)]

An overview about all existings releases can be found here:
* [Overview from all releases in Lib-Action]



Requirements<a name="Requirements" />
---

* On your system you need [JRE 8] or [JDK 8] installed.
* The library [lib-action-0.4.1.jar](#Installation).

In the library are following libraries registered as dependencies:
* The library [lib-logger-0.4.1.jar](#Installation).
  * Included in `Lib-Logger` is the library [log4j-api-2.8.2.jar].
  * Included is `Lib-Logger` is the library [log4j-core-2.8.2.jar].



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
[lib-action-0.4.1.jar]:https://github.com/Naoghuman/lib-action/releases/tag/v0.4.1
[Lib-Logger]:https://github.com/Naoghuman/lib-logger
[lib-logger-0.4.1.jar]:https://github.com/Naoghuman/lib-logger/releases/tag/v0.4.1
[log4j-api-2.8.2.jar]:https://logging.apache.org/log4j/2.0/log4j-web/dependencies.html
[log4j-core-2.8.2.jar]:https://logging.apache.org/log4j/2.0/log4j-web/dependencies.html
[Maven]:http://maven.apache.org/
[NetBeans]:https://netbeans.org/
[Overview from all releases in Lib-Action]:https://github.com/Naoghuman/lib-action/releases
[Pull Request]:https://help.github.com/articles/using-pull-requests
[Release v0.4.1 (05.21.2017)]:https://github.com/Naoghuman/lib-action/releases/tag/v0.4.1


