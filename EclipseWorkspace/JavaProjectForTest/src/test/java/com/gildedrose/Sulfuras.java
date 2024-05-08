package com.gildedrose;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Sulfuras {

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

	@Test @DisplayName(value = "Positive sellin and quality")
	void CP1() {
		Item[] item = new Item[] {new Item("Sulfuras, Hand of Ragnaros",11,80)};
		GildedRose app = new GildedRose(item);
		app.updateQuality();
		assertAll("Properties",
				
				()-> assertEquals("Sulfuras, Hand of Ragnaros", item[0].name, "Nombre del producto"),
				()-> assertEquals(11, item[0].sellIn, "Fecha recomendada"),
				()->assertEquals(80, item[0].quality, "Calidad final")
				
				);
	
	}

}
