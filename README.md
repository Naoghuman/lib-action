Lib-Action
===============

A library for `easy` storing and accessing actions ([EventHandler]&lt;[ActionEvent]&gt;) in a [JavaFX] &amp; [Maven] application.

Current `version` is `0.1.3` (05.2015).



Content
-------

* [Example](#Example)
* [Requirements](#Requirements)
* [Installation](#Installation)
* [Documentation](#Documentation)
* [Contribution](#Contribution)
* [License](#License)
* [Autor](#Autor)
* [Contact](#Contact)



Example<a name="Example" />
-------

```java
/**
 * The facade {@link de.pro.lib.action.api.ActionFacade} supplies a 
 * singleton instance of the Interface {@link de.pro.lib.action.api.IAction}.
 *
 * @author PRo
 * @see de.pro.lib.action.api.IAction
 */
public final class ActionFacade
```

```java
/**
 * Fire an event with the associated actionKey.
 * 
 * @param actionKey The key which allowed access to the associated action.
 */
ActionFacade.getDefault().handle(String actionKey);
```

```java
/**
 * Fire an event with the associated actionKey defined in the <code>ActionTransferModel</code>.<br />
 * 
 * The <code>ActionTransferModel</code> will be stored in the action event and can reached over 
 * <code>event.getSource(): Object</code> in the overriden {@link javafx.event.ActionEvent}.
 * 
 * @param model A <code>ActionTransferModel</code> which contains the actionKey and additional parameters.
 */
    public void handle(ActionTransferModel model);
```

```java
/**
 * Register an action with the specific key.
 * 
 * @param actionKey The key which allowed access to the associated action.
 * @param action The action which should be registered.
 */
ActionFacade.getDefault().register(String actionKey, EventHandler<ActionEvent> action);
```

```java
/**
 * Remove the action with the specific key.
 * 
 * @param actionKey The action which should be removed.
 */
ActionFacade.getDefault().remove(String actionKey);
```


Here you can see an example how to define an action
```java
public void registerOnActionOpenDream() {
    ActionFacade.getDefault().register(
            ACTION__OPEN_DREAM__FROM_NAVIGATION,
            (ActionEvent ae) -> {
                final ActionTransferModel model = (ActionTransferModel) ae.getSource();
                this.show(model.getLongParameter());
            });
}
```


and how the above defined action is fired.
```java
final ActionTransferModel model = new ActionTransferModel();
model.setActionKey(ACTION__OPEN_DREAM__FROM_NAVIGATION);
model.setLongParameter(idToOpen);

ActionFacade.getDefault().handle(model);
```


Requirements<a name="Requirements" />
------------

* On your system you need [JRE 8] or [JDK 8] installed.
* The library [Lib-Action-0.1.3.jar](#Installation).
* The library [Lib-Logger-0.1.0.jar](#Installation).
  * Included is the [log4j-api-2.2.jar].
  * Included is the [log4j-core-2.2.jar].



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
[log4j-api-2.2.jar]:https://logging.apache.org/log4j/2.0/log4j-web/dependencies.html
[log4j-core-2.2.jar]:https://logging.apache.org/log4j/2.0/log4j-web/dependencies.html
[Maven]:http://maven.apache.org/
[NetBeans]:https://netbeans.org/
[Pull Request]:https://help.github.com/articles/using-pull-requests


