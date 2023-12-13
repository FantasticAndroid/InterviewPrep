package com.offline.first.compose.sideeffect

object Unit {

    class University(private val repository: Repository<Student>) {
        fun getPaidCoursesWithTheNumbersOfSubscribedStudents(coursesCount: Int): Map<Course, Int> =

            HashMap<Course, Int>().let { outputMap ->
                repository.get().forEach {
                    it.subscribedCourses.filter { course -> course.isPaid }.forEach { paidCourse->
                        outputMap[paidCourse] = (outputMap[paidCourse] ?:0) + 1
                    }
                }

                outputMap.toList().sortedByDescending { it.second }.take(coursesCount).toMap()
            }


    }


}

private fun getRepo(): Iterable<Student> {
    return arrayListOf(
        Student(
            subscribedCourses = arrayListOf(
                Course(name = "Maths", isPaid = false),
                Course(name = "Arts", isPaid = true)
            )
        ),
        Student(
            subscribedCourses = arrayListOf(
                Course(name = "His", isPaid = true),
                Course(name = "Biology", isPaid = true)
            )
        ),

        Student(
            subscribedCourses = arrayListOf(
                Course(name = "Physics", isPaid = true),
                Course(name = "His", isPaid = true)
            )
        )
    ).asIterable()
}

interface Repository<Student> {
    fun get(): Iterable<com.offline.first.compose.sideeffect.Student> =
        arrayListOf(
            Student(
                subscribedCourses = arrayListOf(
                    Course(name = "Maths", isPaid = false),
                    Course(name = "Arts", isPaid = true)
                )
            ),
            Student(
                subscribedCourses = arrayListOf(
                    Course(name = "His", isPaid = true),
                    Course(name = "Biology", isPaid = true)
                )
            ),

            Student(
                subscribedCourses = arrayListOf(
                    Course(name = "Physics", isPaid = true),
                    Course(name = "His", isPaid = true)
                )
            )
        ).asIterable()

}

typealias Id = Int

data class Course(val name: String, val isPaid: Boolean)
data class Student(val subscribedCourses: List<Course>)