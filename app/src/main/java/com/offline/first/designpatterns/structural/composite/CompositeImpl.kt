package com.offline.first.designpatterns.structural.composite

const val TAG = "CompositeImpl"
object CompositeImpl {

    fun applyCompositeImpl(){

        val shapeLayout = ShapeLayout()

        shapeLayout.addShape(CircleShape(10, 20, 5.0f))
        shapeLayout.addShape(RectangleShape(15, 25))
        shapeLayout.addShape(SquareShape(30))
        shapeLayout.addShape(TriangleShape(5, 15, 50))

        val childShapeLayout = ShapeLayout()
        childShapeLayout.addShape(CircleShape(1, 2, 5.0f))
        childShapeLayout.addShape(RectangleShape(5, 10))
        childShapeLayout.addShape(TriangleShape(5, 5, 50))

        shapeLayout.addShape(childShapeLayout)
        shapeLayout.draw()

    }
}