# Employees List- Outfit7 expertise test

This is a final version of my expertise test, an Android App that is capable of storing and receiving data with Room Persistance Library, RXJava2 using the MVVM(LiveData) and Repository Patterns.


## Building the App

First, clone the repo:
`git clone https://github.com/duxhz/EmployeesO7.git`
The repository consists of two branches:
- develop (default): it is the main branch with all of the commits
- master

Building the sample then depends on your build tools. It was build with Build Tools version 29.0.2
### Android Studio (Recommended)
(These instructions were tested with Android studio version 3.5.3)
- Open Android Studio and select `File->Open...` or from the Android Launcher select `Import project(Eclipse ADT, Gradle, etc.)` and navigate to the root directory of your project.
- Select the directory or drill in and select the file `build.gradle` in the cloned repo.
- Click 'OK' to open the the project in Android Studio.
- A Gradle sync should start, but you can force a sync and build the 'app' module as needed.

## Running the App
Connect an Android device to your development machine or create and emulator with Android Studio.

### Android Studio (Recommended)
- Select `Run -> Run 'app'`(or `Debug 'app'`) from the menu bar
- Select the device you wish to run the app on and click 'OK'

## Using the App

The app consists of three main screens (Fragment):
- Home: Providing user with the list of employees, offering a real-time search. With a single click on one of the employee views a dialog pops-out with the top 5 links received from the Custom Search JSON API(using google.com search engine) which is RESTful.
- Employee Form: Before a user is visible in Home, you must insert it through the form.
- Statistics: All of the queries which calculate statistics about the employees are stored in this screen.

