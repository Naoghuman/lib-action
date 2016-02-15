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
    - [com.github.naoghuman.lib.action.api.ActionClass](#ActionClass)
    - [com.github.naoghuman.lib.action.api.ActionMethod](#ActionMethod)
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
---

### com.github.naoghuman.lib.action.api.ActionFacade<a name="ActionFacade" />

```java
/**
 * The facade {@link com.github.naoghuman.lib.action.api.ActionFacade} provides 
 * access to registered action methods.
 * <ul>
 * <li>Only classes with the annotation {@link com.github.naoghuman.lib.action.api.ActionClass }
 * will be scanned in the method {@link com.github.naoghuman.lib.action.api.ActionFacade#scan() }.</li>
 * <li>Only methods which are marked with the annotation {@link com.github.naoghuman.lib.action.api.ActionMethod }
 * will be registered as action method through the scanning.</li>
 * </ul>
 * 
 * @author Naoghuman
 * @see com.github.naoghuman.lib.action.api.ActionClass
 * @see com.github.naoghuman.lib.action.api.ActionFacade#scan()
 * @see com.github.naoghuman.lib.action.api.ActionMethod
 */
public enum ActionFacade
```

```java
/**
 * Over the value <code>INSTANCE</code> the developer have access to the
 * functionality in the enum <code>ActionFacade</code>.
 */
 INSTANCE;
```

```java
/**
 * Scans all classes for the annotation {@link com.github.naoghuman.lib.action.api.ActionClass }.
 * <ul>
 * <li>If annotated classes will be found all methods in this classes will be 
 * scanned for the annotation {@link com.github.naoghuman.lib.action.api.ActionMethod }.</li>
 * <li>All founded method will be stored internal.</li>
 * <li>Access to the stored action methods happens through the parameter 
 * {@link com.github.naoghuman.lib.action.api.ActionMethod#actionId() }.</li>
 * </ul>
 * 
 * @throws IOException 
 * @see com.github.naoghuman.lib.action.api.ActionFacade#trigger(java.lang.String) 
 * @see com.github.naoghuman.lib.action.api.ActionFacade#trigger(java.lang.String, com.github.naoghuman.lib.action.api.TransferData) 
 */
public void scan() throws IOException
```

```java
/**
 * Triggers the registerd action method which is associated with 
 * {@link com.github.naoghuman.lib.action.api.ActionMethod#actionId() }.
 * <ul>
 * <li>If no action method with this actionId is registerd, then no action event will be triggerd.</li>
 * </ul>
 * 
 * @param actionId The actionId which is defined in the annotation {@link com.github.naoghuman.lib.action.api.ActionMethod}.
 */
public void trigger(String actionId)
```

```java
/**
 * Triggers all registerd action methods which are associated with the 
 * <code>actionId</code> in every <code>TransferData</code> .
 * <ul>
 * <li>Access to the <code>TransferData</code> can be happen during  {@link javafx.event.ActionEvent#getSource() }.</li>
 * <li>If <code>TransferData == null</code> then also <code>ActionEvent#getSource() == null</code>.</li>
 * <li>If no actionId in the TransferData is registerd, then no action event will be triggerd.</li>
 * <li>If no action method with this actionId is registerd, then no action event will be triggerd.</li>
 * </ul>
 * 
 * @param transferDatas The transferDatas which should be received in the registerd action methods.
 */
public void trigger(List<TransferData> transferDatas)
```

```java
/**
 * Triggers the registerd action method with the <code>TransferData</code> 
 * which is associated with the <code>id</code>.
 * <ul>
 * <li>Access to the <code>TransferData</code> can be happen during  {@link javafx.event.ActionEvent#getSource() }.</li>
 * <li>If <code>TransferData == null</code> then also <code>ActionEvent#getSource() == null</code>.</li>
 * <li>If no actionId in this TransferData is registerd, then no action event will be triggerd.</li>
 * <li>If no action method with this actionId is registerd, then no action event will be triggerd.</li>
 * </ul>
 * 
 * @param transferData The transferData which should be received in the registerd action method.
 */
public void trigger(TransferData transferData)
```

```java
/**
 * Triggers the registerd action method with the <code>TransferData</code> 
 * which is associated with the {@link com.github.naoghuman.lib.action.api.ActionMethod#actionId() }.
 * <ul>
 * <li>Access to the <code>TransferData</code> can be happen in the action method during
 * {@link javafx.event.ActionEvent#getSource() }.</li>
 * <li>If <code>TransferData == null</code> then also <code>ActionEvent#getSource() == null</code>.</li>
 * <li>If no action method with this actionId is registerd, then no action event will be triggerd.</li>
 * </ul>
 * 
 * @param actionId The actionId which is defined in the annotation {@link com.github.naoghuman.lib.action.api.ActionMethod}.
 * @param transferData The transferData which should be received in the registerd action method.
 */
public void trigger(String actionId, TransferData transferData)
```


### com.github.naoghuman.lib.action.api.ActionClass<a name="ActionClass" />

```java
/**
 * Marks a <code>class</code> as a class which contains action methods which must 
 * be marked with the annotation {@link com.github.naoghuman.lib.action.api.ActionMethod }.
 * <p>
 * Only classes which are marked with this annotation will be scaned for 
 * action methods. The registration from all action methods should be happen 
 * during starttime through the method {@link com.github.naoghuman.lib.action.api.ActionFacade#scan() }.
 *
 * @author Naoghuman
 * @see com.github.naoghuman.lib.action.api.ActionFacade#scan()
 * @see com.github.naoghuman.lib.action.api.ActionMethod
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE) 
public @interface ActionClass
```


### com.github.naoghuman.lib.action.api.ActionMethod<a name="ActionMethod" />

```java
/**
 * Marks a <code>method</code> as an <code>action</code> method.
 * <p>
 * The marked action method will be only registered if the <code>class</code> 
 * which contains the marked method is annotated with the annotation 
 * {@link com.github.naoghuman.lib.action.api.ActionClass }. The registration 
 * from all action methods should be happen during starttime through the method 
 * {@link com.github.naoghuman.lib.action.api.ActionFacade#scan() }.
 *
 * @author Naoghuman
 * @see com.github.naoghuman.lib.action.api.ActionClass
 * @see com.github.naoghuman.lib.action.api.ActionFacade#scan()
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD) 
public @interface ActionMethod
```

```java
/**
 * Define the <code>action-id</code> for the marked action method which allows
 * to trigger the annotated method.
 * 
 * @return The unique action-id. 
 */
public String actionId() default "unique actionId"; // NOI18N
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
public void setId(String actionId)
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
* The library [Lib-Logger-0.3.0.jar](#Installation).
  * Included is the [log4j-api-2.4.1.jar].
  * Included is the [log4j-core-2.4.1.jar].



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
[log4j-api-2.4.1.jar]:https://logging.apache.org/log4j/2.0/log4j-web/dependencies.html
[log4j-core-2.4.1.jar]:https://logging.apache.org/log4j/2.0/log4j-web/dependencies.html
[Maven]:http://maven.apache.org/
[NetBeans]:https://netbeans.org/
[Overview from all releases in Lib-Action]:https://github.com/Naoghuman/lib-action/releases
[Pull Request]:https://help.github.com/articles/using-pull-requests
[Release v0.2.2 (09.2015)]:https://github.com/Naoghuman/lib-action/releases/tag/v0.2.2


