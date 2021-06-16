Add this in project level gradle.
allprojects {
	repositories {
			...
			maven { url 'https://jitpack.io' }
	}
}

Add this in app level gradle.  
dependencies {
	        implementation 'com.github.umeriqbal97:CommaSeparatedEditText:1.0.0'
}

For xml use following:

<com.fauji.commaseparated.widget.CommaSeparatedEditText
        android:id="@+id/commaSeparatedEditText"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:isSeparateByCommas="true"
        app:layout_constraintTop_toTopOf="parent"
        app:noOfDecimals="2" />
	
For java use following:

commaSeparatedEditText.getTextWithCommas()
commaSeparatedEditText.getTextWithoutCommas()
