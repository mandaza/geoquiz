# GeoQuiz Android App

A geography quiz application built for Android that tests users' knowledge with true/false questions about world geography, oceans, continents, and landmarks.

## 📱 Features

### Core Quiz Functionality
- **5+ Geography Questions**: Test knowledge about oceans, continents, rivers, and landmarks
- **True/False Answers**: Simple and intuitive answer selection
- **Navigation Controls**: 
  - NEXT button with right arrow icon to advance questions
  - PREV button with left arrow icon to go back
  - Tap question text to advance (bonus feature)

### Anti-Cheat System
- **Cheat Detection**: Tracks when users view answers
- **Persistent State**: Cheat status survives device rotations
- **Judgment System**: Shows "Cheating is wrong!" message for cheaters
- **Loophole Prevention**: Users cannot clear cheat status by rotating CheatActivity

### Technical Features
- **ViewModel Architecture**: Survives configuration changes
- **Activity Result API**: Modern way to handle cheat activity results
- **Material Design**: Clean, modern UI with proper button styling
- **Rotation Support**: App maintains state during device orientation changes

## 🏗️ Architecture

- **MainActivity**: Main quiz interface and navigation
- **CheatActivity**: Answer reveal interface with cheat detection
- **QuizViewModel**: Manages quiz state and question bank
- **CheatViewModel**: Preserves cheat status across rotations
- **Question**: Data class for quiz questions

## 🚀 Getting Started

### Prerequisites
- Android Studio Arctic Fox or later
- Android SDK 24+ (API Level 24)
- Java 11 or later

### Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/mandaza/geoquiz.git
   cd GeoQuiz
   ```

2. Open the project in Android Studio

3. Sync Gradle files and build the project

4. Run on an emulator or physical device

### Build Configuration
- **Compile SDK**: 33
- **Min SDK**: 24 (Android 7.0)
- **Target SDK**: 33
- **Kotlin Version**: Latest stable

## 📁 Project Structure

```
app/src/main/
├── java/com/bignerdranch/android/geoquiz/
│   ├── MainActivity.kt          # Main quiz interface
│   ├── CheatActivity.kt         # Cheat interface
│   ├── QuizViewModel.kt         # Quiz state management
│   ├── CheatViewModel.kt        # Cheat state management
│   └── Question.kt              # Question data class
├── res/
│   ├── layout/
│   │   ├── activity_main.xml    # Main quiz layout
│   │   └── activity_cheat.xml   # Cheat activity layout
│   ├── drawable/                # Arrow icons and other graphics
│   └── values/
│       ├── strings.xml          # App strings and questions
│       ├── colors.xml           # App color scheme
│       └── themes.xml           # App themes
└── AndroidManifest.xml          # App manifest
```

## 🎯 Quiz Questions

The app includes questions about:
- Pacific Ocean size comparison
- African geography (Nile River)
- Australian capital (Canberra)
- Middle East geography (Suez Canal)
- American geography (Amazon River)


## 🔧 Technical Implementation

### ViewModel Usage
- **QuizViewModel**: Manages current question index and cheat status array
- **CheatViewModel**: Preserves cheat state across configuration changes
- Both ViewModels extend `androidx.lifecycle.ViewModel`

### State Management
- Question bank stored in ViewModel
- Current question index preserved during rotations
- Per-question cheat tracking with BooleanArray
- Proper state restoration after configuration changes

### UI Components
- LinearLayout-based interface for simplicity
- Material Design buttons with proper styling
- Arrow icons for navigation buttons
- Responsive layout that works on different screen sizes

## 🧪 Testing

The project includes:
- **Unit Tests**: Basic JUnit tests
- **Instrumented Tests**: Android-specific testing
- **Manual Testing**: Verified on multiple device configurations

## 📱 Screenshots

*[Add screenshots of your app here]*

## 🤝 Contributing

This is an educational project based on the Big Nerd Ranch Android Development book. Feel free to:
- Report bugs or issues
- Suggest improvements
- Fork and modify for learning purposes

## 📚 Learning Resources

This project demonstrates:
- Android Activity lifecycle
- ViewModel architecture
- Configuration change handling
- Intent communication between activities
- Modern Android development practices

## 📄 License

This project is created for educational purposes as part of learning Android development.

## 👨‍💻 Author

Created by Prosper T Mandaza
Created as part of Android development learning journey.

---

**Note**: This app successfully implements all 10 required features including the anti-cheat system that prevents users from clearing cheat status by rotating the CheatActivity.
