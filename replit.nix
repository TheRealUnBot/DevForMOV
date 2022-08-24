{ pkgs }: {
    deps = [
        pkgs.zip
        pkgs.bashInteractive
        pkgs.busybox
        pkgs.graalvm11-ce
        pkgs.nginx
        pkgs.python39Full
    ];
}