# SigilsMod
A Paper plugin for SigilsSMP 1.21.11.

## What are Sigils?
Sigils are powerful, unique items that grant their wielder special abilities. 
Each Sigil has its own effect and most are extremely valuable.

## Sigils
| Sigil | Effect |
|---|---|
| Strength | Strength III |
| Speed | Swiftness III |
| Vitality | Health Boost II |
| Luck | Luck V |
| Haste | Haste III |
| Mending | Regeneration III |
| Poison | Poison III |
| Molten | Fire Resistance |
| Hardened | Resistance II |
| Endurance | Saturation II |
| Turtle | Resistance V + Slowness IV |
| Concealment | Invisibility |
| Verity (unobtainable) | hey its me its verity |

## Features
- Sigils!!!
- Persistent Sigil identification using PDC
- Custom crafting recipes :D

## Usage
`/sigil give <player> <sigil>`
<player> must be the player's username. `@` does not work.

## Requirements
Minecraft 1.21.11
PaperMC
Java 21

## Building
```bash
$ cd /path/to/repository
$ ./gradlew build
```
The compiled plugin will be located in `build/libs/`.

## Installation
1. Download/Build the plugin.
2. Copy the .jar into your Paper server's `plugins/` directory.
3. Start/restart the server!

## Development
Built with Java and Gradle.
Package: `xyz.polari5dev.SigilsMod`

## Roadmap
- (perpetual) Update README
- [X] More Sigils
- [X] Working crafting recipe
- [X] More crafting recipes
- [ ] Add glow effect into included potion effects
- [ ] Sigil uniqueness/crafting restrictions (only one of each at a time!)
- [ ] Container restrictions (cannot store in chests)
- [ ] Sigil destruction signal (only allow crafting another if existing sigil is destroyed)
- [ ] Better command feedback (autocomplete, help menu, etc)
