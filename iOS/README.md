# Overview (iOS)

This directory includes sample iOS projects.

## Code Signing

To build and run any of these apps on a device, you'll need to update the 
corresponding project's code signing configs.

Each project's root directory includes a `CodeSigning.xcconfig` file with the
following contents:

```
DEVELOPMENT_TEAM = <Your Team ID>
```

Updating this file with your development team ID should be enough to build and
run without any changes to the Xcode project. 

Your development team ID can be found at https://developer.apple.com/account/
under "Membership details".
