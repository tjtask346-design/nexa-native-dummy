# Nexa Native Fixed - No libs reference
This fixes Unresolved reference 'android' / 'libs' error.
- Removed alias(libs.plugins...) 
- Now uses id("com.android.application") directly
- gradle wrapper included
- Build.yml uses gradle/actions/setup-gradle@v4
Just upload whole folder to GitHub.
