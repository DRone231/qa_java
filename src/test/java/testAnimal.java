import com.example.Animal;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {

    private final Animal animal = new Animal();

    @Test
    void getFoodReturnsGrassForHerbivore() throws Exception {
        assertEquals(List.of("Трава", "Различные растения"), animal.getFood("Травоядное"));
    }

    @Test
    void getFoodReturnsMeatForPredator() throws Exception {
        assertEquals(List.of("Животные", "Птицы", "Рыба"), animal.getFood("Хищник"));
    }

    @Test
    void getFoodThrowsForUnknownKind() {
        Exception e = assertThrows(Exception.class, () -> animal.getFood("Неизвестно"));
        assertTrue(e.getMessage().contains("Неизвестный вид животного"));
    }

    @Test
    void getFamilyReturnsDescription() {
        assertEquals(
                "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи",
                animal.getFamily());
    }
}
