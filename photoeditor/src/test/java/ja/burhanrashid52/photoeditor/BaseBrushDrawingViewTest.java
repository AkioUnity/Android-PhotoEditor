package ja.burhanrashid52.photoeditor;

import android.content.Context;
import android.support.annotation.NonNull;

import org.robolectric.RuntimeEnvironment;

import ja.amg.photoeditor.BrushDrawingView;
import ja.amg.photoeditor.BrushViewChangeListener;

public class BaseBrushDrawingViewTest {
    protected Context mContext = RuntimeEnvironment.systemContext;

    @NonNull
    protected BrushDrawingView setupBrushForTouchEvents(BrushViewChangeListener brushViewChangeListener) {
        BrushDrawingView brushDrawingView = new BrushDrawingView(mContext);
        brushDrawingView.setBrushDrawingMode(true);
        brushDrawingView.setBrushViewChangeListener(brushViewChangeListener);
        brushDrawingView.onSizeChanged(500, 500, 500, 500);
        return brushDrawingView;
    }

}
