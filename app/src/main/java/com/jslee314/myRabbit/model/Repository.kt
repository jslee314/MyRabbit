package com.jslee314.myRabbit.model

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

// DAO를 생성자에서 전용 속성으로 선언합니다. DAO에 대한 액세스만 필요하므로 전체 데이터베이스 대신 DAO를 전달합니다.
class Repository(private val pointDao: PointDao) {

    // Room은 별도의 스레드에서 모든 쿼리를 실행합니다.
    // Observed Flow는 데이터가 변경되면 관찰자에게 알립니다.
    val allPoints: Flow<List<Point>> = pointDao.getAlphabetizedPoint()

    // 기본적으로 Room은 main 스레드에서 정지 쿼리를 실행하므로
    // main 스레드에서 오래 실행되는 데이터베이스 작업을 수행하지 않도록 하기 위해 다른 것을 구현할 필요가 없습니다.
//    @Suppress("RedundantSuspendModifier")
//    @WorkerThread
//    suspend fun insert(word: Word) {
//        wordDao.insert(word)
//    }


}