# GithubKMP

A Kotlin native multiplatform app(Android & iOS) showcasing list of users working in an organisation. The data is consumed from Github API. 

# Architecture of Kotlin Native multi-platform projects

<p align="center">
<img width="563" alt="Screenshot 2019-04-22 at 9 49 05 AM" src="https://user-images.githubusercontent.com/14856659/56482876-0f170a00-64e4-11e9-9d2c-4c877c2d1af8.png">
</p>

The shared code or module consist of Network and Database repository. You can even add more repositories as per your need and expose the data that needs to be shown on the UI of a respective platform. The shared module is imported as a jar library in android project and framework in iOS project. 

# How to run?

* Just clone this repository in Android Studio.
* For Xcode, download the project manually and open the iosApp folder in the Xcode.
* Press the "Run" button.

# Ran into trouble?

Contact me at: 
* sagarsuri56@gmail.com
* [LinkedIn](https://www.linkedin.com/in/sagar-suri/)
