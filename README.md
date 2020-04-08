# Minesweeper

[![Build Status](https://img.shields.io/endpoint.svg?url=https%3A%2F%2Factions-badge.atrox.dev%2Firishshagua%2Fminesweeper%2Fbadge%3Fref%3Dmaster&style=popout)](https://actions-badge.atrox.dev/irishshagua/minesweeper/goto?ref=master)
![Publish Tagged Releases](https://github.com/irishshagua/minesweeper/workflows/Publish%20Tagged%20Releases/badge.svg)

## Purpose
Sample project to play with Java and JavaFX using the latest and greatest features (at time of writing that's Java 14).

Goals of the project are:    
 - [x] Run Java FX with Java 14 preview features
 - [x] Have a build running in Github which produces a downloaded game
   * [] Have builds for every platform 
 - [x] Make the releases conditional
 - [] Create a Playable Minesweeper
 - [] Have some autoplay logic which can solve the Minesweeper game

## Release
To create a release you need to push a new `version` tag to the master branch. A version tag is recognised as anything which start with `v`. We will use `v0.1` as the format. Creating the tag is done as per below:

```bash
git tag -a v0.1 -m "Initial tagged release"
git push --tags
```

## Assets
Images used in the app are from [pixabay](https://pixabay.com/). They're all marked as free for use without licence.
