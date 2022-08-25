{ pkgs }: {
    deps = [
        pkgs.webfs
        pkgs.python39Packages.pip
        pkgs.nano
        pkgs.zip
        pkgs.bashInteractive
        pkgs.busybox
        pkgs.graalvm11-ce
        pkgs.nginx
        pkgs.python39Full
    ];
}