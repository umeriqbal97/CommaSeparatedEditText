Add this in project level gradle.<br>
allprojects {
<br>
	repositories {<br>
			...<br>
			maven { url 'https://jitpack.io' }<br>
	}<br>
}<br>
<br><br>
Add this in app level gradle.  <br>
dependencies {<br>
	        implementation 'com.github.umeriqbal97:CommaSeparatedEditText:1.0.5'<br>
}<br>
<br><br>
For xml use following:<br><br>

<com.fauji.commaseparated.widget.CommaSeparatedEditText<br>
        android:id="@+id/commaSeparatedEditText"<br>
        android:layout_width="match_parent"<br>
        android:layout_height="wrap_content"<br>
        app:isSeparateByCommas="true"<br>
        app:layout_constraintTop_toTopOf="parent"<br>
        app:noOfDecimals="2" /><br>
	<br><br>
For java use following:<br>
<br>
commaSeparatedEditText.getTextWithCommas()<br>
commaSeparatedEditText.getTextWithoutCommas()<br>
