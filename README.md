# TimerFit

Electron app for monitoring fitness exercices (coding
[Kata](https://en.wikipedia.org/wiki/Kata))

## Overview

At some point in my daily work I figured out my workflow sucks a lot. Few days
later, a friend of mine shew me he keeps track of his daily workout routine
with a rich-text-formatted file.

I want to combine these two events, improve how I do code and give this friend
an easier way to workout with a tiny js-backed app which would run on Electron.
It's nothing serious -- just having fun with a friend and up-skill myself.

I use [ClojureScript](https://github.com/clojure/clojurescript), `re-frame`,
React.js (through `reagent`), [Material design](http://www.material-ui.com/). My
coding flow involves hot code reloading through
[`figwheel`](https://github.com/bhauman/lein-figwheel). This whole set is pretty
awesome and I'm very lucky to use it at work! 😁

A detailed overview is available in file [TODO.org](./TODO.org).

## Setup

To get an interactive development environment run:

    lein figwheel

and open your browser at [localhost:3449](http://localhost:3449/). This will
auto compile and send all changes to the browser without the need to reload.
After the compilation process is complete, you will get a Browser Connected
REPL. An easy way to try it is:

    (js/alert "Am I connected?")

and you should see an alert in the browser window.

To clean all compiled files:

    lein clean

To create a production build run:

    lein do clean, cljsbuild once min

And open your browser in `resources/public/index.html`. You will neither get
live reloading nor a REPL.

## License

Copyright © 2016 piotr-yuxuan

Distributed under the GNU General Public Licence either version 3.0 or (at your
option) any later version.
