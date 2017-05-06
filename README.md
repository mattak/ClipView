# ClipView ![Maven Central](https://maven-badges.herokuapp.com/maven-central/me.mattak/clipview/badge.svg) ![Build Status](https://travis-ci.org/mattak/ClipView.svg?branch=master)

Android library for clipping view.

# Install

```gradle
compile 'me.mattak:clipview:0.0.3'
```

# Usage

```xml
<me.mattak.clipview.ClipFrameLayout
    android:layout_width="match_parent"
    android:layout_height="20dp"
    android:layout_marginBottom="10dp"
    app:clipPadding="2dp"
    app:clipRound="8dp">

    <View
        android:layout_width="5dp"
        android:layout_height="match_parent"
        android:background="@android:color/holo_red_light" />

</me.mattak.clipview.ClipFrameLayout>
```

![clipview](./art/clipview.png)

# ACKNOWLEDGEMENTS

- [@pine](https://github.com/pine) for updating build tool-chains

