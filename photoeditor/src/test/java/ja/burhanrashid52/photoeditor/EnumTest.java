package ja.burhanrashid52.photoeditor;

import org.junit.Test;

import ja.amg.photoeditor.PhotoFilter;
import ja.amg.photoeditor.ViewType;

import static org.junit.Assert.assertEquals;

public class EnumTest {

    @Test
    public void testNumberOfViewTypes() {
        assertEquals(ViewType.values().length, 4);
    }

    @Test
    public void testNumberOfPhotoFilterTypes() {
        assertEquals(PhotoFilter.values().length, 24);
    }

}