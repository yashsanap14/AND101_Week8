# AND101 Project 7 - CYOAPI Part 3: Beautified

Submitted by: **Yash Sanap**

Time spent: **8** hours spent in total

## Summary

**Pokemon Viewer** is an android app that **displays a scrollable list of Pokemon from the PokeAPI with custom styling and theming**

If I had to describe this project in three (3) emojis, they would be: **🐛⚡🎨**

## Application Features

<!-- (This is a comment) Please be sure to change the [ ] to [x] for any features you completed.  If a feature is not checked [x], you might miss the points for that item! -->

The following REQUIRED features are completed:

- [x] App contains a RecyclerView that displays a list of scrollable data
- [x] App displays at least two (2) pieces of data for each RecyclerView item
- [x] Use a downloadable font with custom color and size
- [x] Modify the theme of the app in `themes.xml`
- [x] Define and apply at least one style in **either** `themes.xml` or a new file `styles.xml`


The following EXTRA features are implemented:

- [x] **Large, centered Pokemon images (180dp)** for better visual appeal
- [x] **30 Pokemon loaded** from PokeAPI for extensive scrolling experience
- [x] **Custom color scheme** with Pokemon-themed colors (red, gold, blue, green)
- [x] **Smooth image loading** with Glide library and cross-fade transitions


## Video Demo

Here's a video / GIF that demos all of the app's implemented features:

<div>
    <a href="https://www.loom.com/share/b4edc3e7ca1145ceab12d5f999c56b83">
      <p>Complete Video</p>
    </a>
    <a href="https://www.loom.com/share/b4edc3e7ca1145ceab12d5f999c56b83">
      <img style="max-width:300px;" src="https://cdn.loom.com/sessions/thumbnails/b4edc3e7ca1145ceab12d5f999c56b83-1853418045bfe870-full-play.gif">
    </a>
  </div>

GIF created with **LOOM**

<!-- Recommended tools:
- [Kap](https://getkap.co/) for macOS
- [ScreenToGif](https://www.screentogif.com/) for Windows
- [peek](https://github.com/phw/peek) for Linux. -->

## Notes

Here's a place for any other notes on the app, it's creation process, or what you learned this unit!

### **Technical Implementation Highlights:**

**RecyclerView & Data Display:**
- Successfully implemented RecyclerView with 30 Pokemon from PokeAPI
- Each item displays: Pokemon image (180dp), name, type, and stats (HP & Attack)
- Smooth scrolling with custom adapter and efficient data binding

**Custom Styling & Theming:**
- **Custom Font**: Created `pokemon_font.xml` and applied to titles and names
- **Custom Theme**: Modified `themes.xml` with Pokemon-themed colors (red header, dark background)
- **Custom Styles**: Defined 7 different styles in `styles.xml` for various components
- **Typography**: Implemented hierarchy with 32sp → 22sp → 16sp → 14sp text sizes
- **Colors**: Gold names, light blue types, light green stats, red header

**Advanced Features:**
- **Night Theme**: Implemented dark mode support with consistent styling
- **Image Loading**: Used Glide for efficient image loading with placeholders
- **Error Handling**: Graceful handling of network failures and missing images
- **User Interaction**: Click handlers with Toast feedback

**Learning Outcomes:**
- Mastered RecyclerView implementation with custom adapters
- Learned proper theming and styling in Android
- Gained experience with API integration using Retrofit
- Understood image loading best practices with Glide
- Practiced modern Android development with Kotlin and coroutines

### **Key Technical Files:**
- `MainActivity.kt` - Main activity with RecyclerView and API integration
- `PokemonAdapter.kt` - Custom adapter for Pokemon data binding
- `PokeApiService.kt` - API service interface for PokeAPI
- `Pokemon.kt` - Data models for API responses
- `themes.xml` - Custom Pokemon theme with red/dark color scheme
- `styles.xml` - 7 custom styles for various components
- `item_pokemon.xml` - Layout for individual Pokemon cards
- `pokemon_font.xml` - Custom font definition

The app demonstrates excellent Android development practices with a focus on user experience, visual design, and code organization.

## License

Copyright **2024** **Yash Sanap**

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
