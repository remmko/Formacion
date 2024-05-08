package com.gildedrose;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GildedRoseTest2 {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	
	@Test @DisplayName(value = "Positive Quality and Sellin")
	void CP1() {
		Item[] item = new Item[] {new Item("Name1",2,1)};
		GildedRose app = new GildedRose(item);
		app.updateQuality();
		assertAll("Properties",
				
				()-> assertEquals("Name1", item[0].name, "Nombre del producto"),
				()-> assertEquals(1, item[0].sellIn, "Fecha recomendada"),
				()->assertEquals(0, item[0].quality, "Calidad final")
				
				);
	}
	
	
	@Test @DisplayName(value = "Positive Quality and Sellin and Final quality => 0")
	void CP2() {
		Item[] item = new Item[] {new Item("Name2",4,3)};
		GildedRose app = new GildedRose(item);
		app.updateQuality();
		assertEquals(3, item[0].sellIn, "Fecha recomendada");
		assertEquals(2, item[0].quality, "Calidad final");
	}
	
	@Test	 @DisplayName(value = "Error for negative quality")		//FALIED    
	void CP3() {
		Item[] item = new Item[] {new Item("Name3",3,-1)};
		GildedRose app = new GildedRose(item);
		app.updateQuality();
		assertAll("Properties",
				
				()-> assertEquals("Name3", item[0].name, "Nombre del producto"),
				()-> assertEquals(3, item[0].sellIn, "Fecha recomendada"),
				()->assertEquals(-1, item[0].quality, "Calidad final")
				
				);
	
	}
	
	@Test @DisplayName(value = "Positive sellin and Quality 0")
	void CP4() {
		Item[] item = new Item[] {new Item("Name4",2,0)};
		GildedRose app = new GildedRose(item);
		app.updateQuality();
		assertAll("Properties",
				
				()-> assertEquals("Name4", item[0].name, "Nombre del producto"),
				()-> assertEquals(1, item[0].sellIn, "Fecha recomendada"),
				()->assertEquals(0, item[0].quality, "Calidad final")
				
				);
	
	}
	
	@Test  @DisplayName(value = "Negative Sellin and Positive quality with 0 expected")
	void CP5() {
		Item[] item = new Item[] {new Item("Name5",-1,1)};
		GildedRose app = new GildedRose(item);
		app.updateQuality();
		assertAll("Properties",
				
				()-> assertEquals("Name5", item[0].name, "Nombre del producto"),
				()-> assertEquals(-2, item[0].sellIn, "Fecha recomendada"),
				()->assertEquals(0, item[0].quality, "Calidad final")
				
				);
	
	}
	
	@Test  @DisplayName(value = "Negative sellin")
	void CP6() {
		Item[] item = new Item[] {new Item("Name6",-2,7)};
		GildedRose app = new GildedRose(item);
		app.updateQuality();
		assertAll("Properties",
				
				()-> assertEquals("Name6", item[0].name, "Nombre del producto"),
				()-> assertEquals(-3, item[0].sellIn, "Fecha recomendada"),
				()->assertEquals(5, item[0].quality, "Calidad final")
				
				);
	
	}
	
	
	@Test  @DisplayName(value = "Negative sellin, expected 0 quality")  //FAILED
	void CP7() {
		Item[] item = new Item[] {new Item("Name7",-3,0)};
		GildedRose app = new GildedRose(item);
		app.updateQuality();
		assertAll("Properties",
				
				()-> assertEquals("Name7", item[0].name, "Nombre del producto"),
				()-> assertEquals(-3, item[0].sellIn, "Fecha recomendada"),
				()->assertEquals(0, item[0].quality, "Calidad final")
				
				);
	
	}
	
	@Test @DisplayName(value = "Negative sellin and quality, negative sellin and 0 quality expected")  //FAILED
	void CP8() {
		Item[] item = new Item[] {new Item("Name8",-1,-3)};
		GildedRose app = new GildedRose(item);
		app.updateQuality();
		assertAll("Properties",
				
				()-> assertEquals("Name8", item[0].name, "Nombre del producto"),
				()-> assertEquals(-2, item[0].sellIn, "Fecha recomendada"),
				()->assertEquals(0, item[0].quality, "Calidad final")
				
				);
	
	}


}
