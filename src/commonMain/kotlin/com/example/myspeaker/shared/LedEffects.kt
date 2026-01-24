package com.example.myspeaker.shared

/**
 * LED Effect types that match ESP32 led_effects.h
 */
enum class LedEffect(val id: Int, val displayName: String, val description: String) {
    OFF(0, "Off", "No LED effect"),
    SOLID(1, "Solid", "Single solid color"),
    BREATHING(2, "Breathing", "Gentle pulsing effect"),
    RAINBOW(3, "Rainbow", "Cycling rainbow colors"),
    RAINBOW_WAVE(4, "Rainbow Wave", "Moving rainbow pattern"),
    COLOR_WIPE(5, "Color Wipe", "Sequential color fill"),
    THEATER_CHASE(6, "Theater Chase", "Chasing lights effect"),
    STROBE(7, "Strobe", "Rapid flashing"),
    SPARKLE(8, "Sparkle", "Random twinkling"),
    FIRE(9, "Fire", "Flickering fire effect"),
    METEOR(10, "Meteor", "Falling meteor trail"),
    BOUNCE(11, "Bounce", "Bouncing ball effect"),
    GRADIENT(12, "Gradient", "Smooth color gradient"),
    PULSE(13, "Pulse", "Rhythmic pulsing"),
    WAVE(14, "Wave", "Moving wave pattern"),
    SCAN(15, "Scanner", "Back and forth scanning"),
    TWINKLE(16, "Twinkle", "Random twinkles"),
    RUNNING(17, "Running Lights", "Running light pattern"),
    COMET(18, "Comet", "Comet with tail"),
    FIREWORK(19, "Firework", "Exploding firework"),
    MUSIC_REACTIVE(20, "Music Reactive", "Responds to music"),
    VU_METER(21, "VU Meter", "Audio level visualization");
    
    companion object {
        fun fromId(id: Int): LedEffect = entries.find { it.id == id } ?: OFF
        
        // Effects that need speed control
        val SPEED_EFFECTS = listOf(
            BREATHING, RAINBOW, RAINBOW_WAVE, COLOR_WIPE, THEATER_CHASE,
            STROBE, SPARKLE, METEOR, BOUNCE, PULSE, WAVE, SCAN,
            TWINKLE, RUNNING, COMET, FIREWORK
        )
        
        // Effects that use primary color only
        val SINGLE_COLOR_EFFECTS = listOf(SOLID, BREATHING, COLOR_WIPE, STROBE, SPARKLE, PULSE)
        
        // Effects that use two colors
        val DUAL_COLOR_EFFECTS = listOf(GRADIENT, WAVE, SCAN)
        
        // Effects that ignore user colors
        val AUTO_COLOR_EFFECTS = listOf(RAINBOW, RAINBOW_WAVE, FIRE, MUSIC_REACTIVE, VU_METER)
    }
}

/**
 * Gradient types for LED effects
 */
enum class GradientType(val id: Int, val displayName: String) {
    LINEAR(0, "Linear"),
    CENTER(1, "Center Out"),
    EDGES(2, "Edges In"),
    WAVE(3, "Wave");
    
    companion object {
        fun fromId(id: Int): GradientType = entries.find { it.id == id } ?: LINEAR
    }
}

/**
 * Color preset for quick LED color selection
 */
data class ColorPreset(
    val name: String,
    val r: Int,
    val g: Int,
    val b: Int
) {
    val rgb: Int get() = (r shl 16) or (g shl 8) or b
    
    companion object {
        val PRESETS = listOf(
            ColorPreset("Red", 255, 0, 0),
            ColorPreset("Orange", 255, 128, 0),
            ColorPreset("Yellow", 255, 255, 0),
            ColorPreset("Green", 0, 255, 0),
            ColorPreset("Cyan", 0, 255, 255),
            ColorPreset("Blue", 0, 0, 255),
            ColorPreset("Purple", 128, 0, 255),
            ColorPreset("Pink", 255, 0, 128),
            ColorPreset("White", 255, 255, 255),
            ColorPreset("Warm White", 255, 200, 150),
            ColorPreset("Cool White", 200, 220, 255),
        )
    }
}
