package com.example.myunittesting

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.mockito.Mockito.*

class MainViewModelTest {

    private  lateinit var mainViewModel: MainViewModel
    private lateinit var cuboidModel: CuboidModel

    private val dummyLength = 12.0
    private val dummyWidth = 7.0
    private val dummyHeight = 6.0


    private val dummyVolume = 504.0
    private val dummyCircumference = 100.0
    private val dummySurfaceArea = 396.0

    @Before
    fun before(){
        cuboidModel = mock(CuboidModel::class.java)
        mainViewModel = MainViewModel(cuboidModel)
    }

    @Test
    fun getCircumference() {
        cuboidModel = CuboidModel()
        mainViewModel = MainViewModel(cuboidModel)
        mainViewModel.save(dummyLength,dummyWidth,dummyHeight)
        val circumFerence = mainViewModel.getCircumference()
        assertEquals(dummyCircumference,circumFerence,0.0001)
        print(circumFerence)
    }

    @Test
    fun getSurfaceArea() {
        cuboidModel = CuboidModel()
        mainViewModel = MainViewModel(cuboidModel)
        mainViewModel.save(dummyWidth,dummyLength,dummyHeight)
        val surfaceArea = mainViewModel.getSurfaceArea()
        assertEquals(dummySurfaceArea,surfaceArea,0.0001)
        print(surfaceArea)
    }

    @Test
    fun getVolume() {
        cuboidModel = CuboidModel()
        mainViewModel = MainViewModel(cuboidModel)
        mainViewModel.save(dummyWidth, dummyLength, dummyHeight)
        val volume = mainViewModel.getVolume()
        assertEquals(dummyVolume, volume, 0.0001)
        print(volume)
    }

    @Test
    fun getMockVolume(){
        `when`(mainViewModel.getVolume()).thenReturn(dummyVolume)
        val volume = mainViewModel.getVolume()
        verify(cuboidModel).getVolume()
        assertEquals(dummyVolume,volume,0.0001)
    }

    @Test
    fun testMockCircumference() {
        `when`(mainViewModel.getCircumference()).thenReturn(dummyCircumference)
        val circumference = mainViewModel.getCircumference()
        verify(cuboidModel).getCircumference()
        assertEquals(dummyCircumference, circumference, 0.0001)
    }
    @Test
    fun testMockSurfaceArea() {
        `when`(mainViewModel.getSurfaceArea()).thenReturn(dummySurfaceArea)
        val surfaceArea = mainViewModel.getSurfaceArea()
        verify(cuboidModel).getSurfaceArea()
        assertEquals(dummySurfaceArea, surfaceArea, 0.0001)
    }

}