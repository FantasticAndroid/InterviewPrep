package com.offline.first.designpatterns.structural.composite

import android.util.Log

/**
 * Component
 */
interface Renderer {
    fun draw()
}

/**
 * Leaf Class
 * @constructor
 */
open class Shape(val x: Int,val y: Int) : Renderer {
    override fun draw() {
        Log.d(TAG, "draw Shape: x: $x, y: $y")
    }
}


/**
 * Client
 * @constructor
 */
class CircleShape(x: Int, y: Int, private val radius: Float) : Shape(x, y) {

    override fun draw() {
        // Actual Drawing
        Log.d(TAG, "draw CircleShape: x: $x, y: $y, radius: $radius")
    }
}

/**
 * Leaf
 * @constructor
 */
class RectangleShape(x: Int, y: Int) : Shape(x, y) {

    override fun draw() {
        // Actual Drawing
        Log.d(TAG, "draw RectangleShape: x: $x, y: $y")
    }
}

/**
 * @constructor
 */
class SquareShape(x: Int) : Shape(x, x) {

    override fun draw() {
        // Draw Square
        Log.d(TAG, "draw SquareShape: x: $x, y: $y")
    }
}

/**
 * @constructor
 */
class TriangleShape(val x: Int,val y: Int, private val z: Int) : ShapeLayout() {

    override fun draw() {
        // Draw triangle
        Log.d(TAG, "draw TriangleShape: x: $x, y: $y, z:$z")
    }
}

/**
 * Composite
 */
open class ShapeLayout : Renderer {

    private val shapes = ArrayList<Renderer>()

    fun addShape(renderer: Renderer){
        shapes.add(renderer)
    }

    fun removeShape(renderer: Renderer){
        shapes.remove(renderer)
    }

    override fun draw() {
        shapes.forEach {
            it.draw()
        }
    }
}