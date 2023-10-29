package com.offline.first.background

import java.util.concurrent.Callable
import java.util.concurrent.Executors

object ThreadPoolDemo {

    fun applyThreadPoolDemo2(){


        /*Schedulers.newThread()

        val threadPoolExecutor
        = ThreadPoolExecutor( 3,
        5,
        5L, TimeUnit.SECONDS,
            BlockingQueue<Runnable>())*/



    }















    fun applyThreadPoolDemo1() {
        val threadPool = Executors.newFixedThreadPool(3)

        val taskList = ArrayList<Callable<String>>().apply {
            add(object : Callable<String> {
                override fun call(): String {
                    return myTask(size)
                }
            })
        }

        val futureTaskList = threadPool.invokeAll(taskList)
        futureTaskList.forEach {futureTask ->
            try {
                futureTask.get()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    /**
     * Long Running Task this is
     * @param taskNo Int
     * @return String
     */
    private fun myTask(taskNo: Int): String {
        return "TaskNo: $taskNo"
    }

}