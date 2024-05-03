package com.gildedrose;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AgedBrie {

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

	@Test	@DisplayName(value="Positive sellin and max quality")
	void CP1() {
		
		Item[] item = new Item[] {new Item("Aged Brie",3,50)};
		GildedRose app = new GildedRose(item);
		app.updateQuality();
		assertAll("Properties",
				
				()-> assertEquals("Aged Brie", item[0].name, "Nombre del producto"),
				()-> assertEquals(2, item[0].sellIn, "Fecha recomendada"),
				()->assertEquals(50, item[0].quality, "Calidad final")
				
				);
	}
	
	@Test @DisplayName(value="Negative sellin and positive quality")
	void CP2() {
		Item[] item = new Item[] {new Item("Aged Brie",-1,49)};
		GildedRose app = new GildedRose(item);
		app.updateQuality();
		assertAll("Properties",
				
				()-> assertEquals("Aged Brie", item[0].name, "Nombre del producto"),
				()-> assertEquals(-2, item[0].sellIn, "Fecha recomendada"),
				()->assertEquals(50, item[0].quality, "Calidad final")
				
				);
	}
	
	@Test @DisplayName(value="0 sellin and positive quality")  //FAILED
	void CP3() {
		Item[] item = new Item[] {new Item("Aged Brie",0,25)};
		GildedRose app = new GildedRose(item);
		app.updateQuality();
		assertAll("Properties",
												
				()-> assertEquals("Aged Brie", item[0].name, "Nombre del producto"),
				()-> assertEquals(-1, item[0].sellIn, "Fecha recomendada"),
				()->assertEquals(26, item[0].quality, "Calidad final")
				
				);
	}
	
	@Test @DisplayName(value="Negative sellin and quality < 50")
	void CP4() {
		Item[] item = new Item[] {new Item("Aged Brie",-2,33)};
		GildedRose app = new GildedRose(item);
		app.updateQuality();
		assertAll("Properties",
				
				()-> assertEquals("Aged Brie", item[0].name, "Nombre del producto"),
				()-> assertEquals(-3, item[0].sellIn, "Fecha recomendada"),
				()->assertEquals(35, item[0].quality, "Calidad final")
				
				);
	}
}
