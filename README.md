# readme e-Native Personal Picture Storage

## Project Background
e-Native Personal Picture Storage (eNPPS) is an application that provide a user to keep personal photo in database as portable storage. Example, grab a photo of poster, important receipt or any document and store it into cloud database. It easily to organize picture or find it later in search at main activity. Also, keep all photos and share it with others.

---

## Module Application

**Account Module**
- Only one user account can access to system
- Access to system by registering and login account
- Submit an image into database.

**Image Module**
- Various each image by putting caption.
- Store all image and caption.
- Review all stored image.
- Deleted all stored image. 

---

## Libraries/external API’s are being used

**Firebase**

Introduction: Firebase is a mobile and web app development platform that provides developers with a plethora of tools and services to help them develop high-quality apps, grow their user base, and earn more profit.

Firebase Service

•	Real time Database: The Firebase Real-time Database is a cloud-hosted NoSQL database that lets you store and sync between your users in real-time.

•	Authentication: Firebase Authentication provides backend services, easy-to-use SDKs, and ready-made UI libraries to authenticate users to your app.

•	Firebase Cloud Messaging (FCM): Firebase Cloud Messaging (FCM) provides a reliable and battery-efficient connection between your server and devices that allows you to deliver and receive messages and notifications on iOS, Android, and the web at no cost.

•	Firebase Database Query: Firebase has simplified the process of retrieving specific data from the database through queries.

•	Remote Config: Remote config essentially allows us to publish updates to our users immediately. Whether we wish to change the color scheme for a screen, the layout for a particular section in our app or show promotional/seasonal options.

•	Firestore: Cloud Firestore is a NoSQL document database that lets you easily store, sync, and query data for your mobile and web apps at a global scale.

**Picasso**

Introduction: Displaying images is easiest using a third party library such as Picasso from Square which will download and cache remote images and abstract the complexity behind an easy to use DSL. The gradle downloads jar by add this compile 'com.squareup.picasso:picasso:2.5.2' in build.gradle.

---

## How setup the development environment

In this project development environment it required to used API Firebase and Picasso. There is the steps of set up those API: 

**Add Firebase**

1-Open the Firebase Assistant in Android Studio then click Tools > Firebase to open the Assistant Window.

2-Click the connect to Firebase button to connect to Firebase and add the necessary code to apps.

3-Create a Firebase project in the Firebase console. 

4-Otherwise, click Add project.

5-Click Add Firebase to Android apps and follow the setup steps. 

6-When prompted, enter apps package name. 

7-It's important to enter the package name of apps is using, this can only be set when add an apps to Firebase project.

8-At the end, download a google-services.json file.

9-If you haven't done so already, copy this into your project's module folder, typically app.


**Add Picasso**

1-Downloading the JAR file from Picasso's website. Start by downloading the JAR file from Picasso's website. 

2-Installing is done the usual manner.

3-If using Android Studio, add compile 'com.squareup.picasso:picasso:2.3.3' to the build.gradle file in the dependency section.

4-Create a new project in IDE of choice and make sure to select a blank Activity if using Android Studio.

5-Open the layout file for the main Activity and add an ImageView to the layout. 

6-In the first line, get a reference to the ImageView instance in the layout file.

7-Load an image into the image view using the Picasso library. 

8-Finally, tell Picasso where it should display the image when it's fetched by calling into and pass in the imageView object.



