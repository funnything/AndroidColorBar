/**
 *  Copyright 2010 funnything
 *
 *  Licensed under the Apache License, Version 2.0 (the &quot;License&quot;);
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an &quot;AS IS&quot; BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package jp.funnything.colorbar;

import android.content.Context;
import android.util.AttributeSet;

public class CMYKMagentaBarView extends CMYKBarView {
    public CMYKMagentaBarView( Context context ) {
        super( context );
    }

    public CMYKMagentaBarView( Context context , AttributeSet attrs ) {
        super( context , attrs );
    }

    public CMYKMagentaBarView( Context context , AttributeSet attrs , int defStyle ) {
        super( context , attrs , defStyle );
    }

    @Override
    protected int getIndex() {
        return 1;
    }
}
