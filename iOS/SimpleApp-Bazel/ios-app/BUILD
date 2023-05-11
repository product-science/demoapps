load("@build_bazel_rules_apple//apple:ios.bzl", "ios_application")
load(
    "@build_bazel_rules_swift//swift:swift.bzl",
    "swift_library",
)
load(
    "@bazel_skylib//rules:common_settings.bzl",
    "bool_flag",
)
load(":configuration/codesign.bzl", "BUNDLE_ID")

swift_library(
    name = "SimpleAppLib",
    srcs = glob([
        "SimpleApp/**/*.swift",
    ]),
    data = [
        "SimpleApp/Base.lproj/Main.storyboard",
    ],
    module_name = "SimpleAppLib",
)

bool_flag(
    name = "enableProvisioning",
    build_setting_default = False,
    visibility = ["//visibility:public"],
)

config_setting(
    name = "enableProvisioningSetting",
    flag_values = {
        ":enableProvisioning": "True",
    },
)

ios_application(
    name = "SimpleApp",
    bundle_id = BUNDLE_ID,
    families = [
        "iphone",
        "ipad",
    ],
    frameworks = [
    ],
    infoplists = [
        ":SimpleApp/Info.plist",
    ],
    launch_storyboard = "SimpleApp/Base.lproj/LaunchScreen.storyboard",
    minimum_os_version = "15.0",
    provisioning_profile = ":configuration/SimpleApp.mobileprovision",
    deps = [
        ":SimpleAppLib",
    ],
)
