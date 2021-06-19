Comma Separated EditText
========================

A faster way to achieve comma separated amount in edittext. This library is 100% build on kotlin.

![CommaSeparatedEdittext](https://github.com/umeriqbal97/CommaSeparatedEditText/blob/master/screenshot.gif)

This library extends the TextInputEditText class to achieve the above desired output.

Gradle
------
```
dependencies {
    ...
    implementation 'com.github.umeriqbal97:CommaSeparatedEditText:1.0.5'
}
```

Project Gradle
--------------
```
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```

XML Usage
---------

There are two attributes are added:
	• isSeparateByCommas
	• noOfDecimals

```xml
  <com.fauji.commaseparated.widget.CommaSeparatedEditText
        android:id="@+id/commaSeparatedEditText"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:isSeparateByCommas="true"
        app:noOfDecimals="2" />
```

Java Usage
----------

Use the below functions to get your desird text from edittext.

```
commaSeparatedEditText.getTextWithCommas()
commaSeparatedEditText.getTextWithoutCommas()
```
