package org.moreunit.core.ui;

import org.eclipse.jface.layout.PixelConverter;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.forms.events.ExpansionAdapter;
import org.eclipse.ui.forms.events.ExpansionEvent;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.SharedScrolledComposite;

public class ExpandableCompositeContainer extends Composite
{
    private final ScrolledComposite scrolledComposite;

    public ExpandableCompositeContainer(Composite parent, int heightHintInChars)
    {
        super(new ScrolledComposite(parent, heightHintInChars), SWT.NO_BACKGROUND);

        setFont(parent.getFont());
        applyStretchedGridLayout(this);

        ((GridLayout) getLayout()).marginRight = 10;

        scrolledComposite = (ScrolledComposite) getParent();
        scrolledComposite.setContent(this);
    }

    private static Composite applyStretchedGridLayout(Composite c)
    {
        GridLayout layout = new GridLayout();
        layout.marginHeight = 0;
        layout.marginWidth = 0;
        c.setLayout(layout);

        c.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        return c;
    }

    /**
     * Important: {@code parent} must be a child of this container
     */
    public ExpandableComposite newExpandableComposite(Composite parent, String label, boolean expanded, ExpandableContent content)
    {
        ExpandableComposite exComp = new ExpandableComposite(parent, SWT.NONE, ExpandableComposite.TWISTIE | ExpandableComposite.CLIENT_INDENT);
        exComp.setText(label);
        exComp.setExpanded(expanded);
        exComp.setFont(JFaceResources.getFontRegistry().getBold(JFaceResources.DIALOG_FONT));

        exComp.setLayoutData(content.getLayoutData());

        exComp.addExpansionListener(new ExpansionAdapter()
        {
            @Override
            public void expansionStateChanged(final ExpansionEvent e)
            {
                reflow();
            }
        });

        exComp.setClient(content.createBody(exComp));

        return exComp;
    }

    public void reflow()
    {
        scrolledComposite.reflow();
    }

    private static class ScrolledComposite extends SharedScrolledComposite
    {
        public ScrolledComposite(Composite parent, int heightHintInChars)
        {
            super(applyStretchedGridLayout(parent), SWT.V_SCROLL | SWT.H_SCROLL);

            setFont(parent.getFont());

            setExpandHorizontal(true);
            setExpandVertical(true);

            addControlListener(new ControlAdapter()
            {
                @Override
                public void controlResized(final ControlEvent e)
                {
                    getVerticalBar().setVisible(true);
                }
            });

            GridData gridData = LayoutData.fillGrid();
            gridData.heightHint = new PixelConverter(parent).convertHeightInCharsToPixels(heightHintInChars);
            setLayoutData(gridData);
        }

        public void reflow()
        {
            reflow(true);
        }
    }
    public static interface ExpandableContent
    {
        Control createBody(ExpandableComposite expandableComposite);

        Object getLayoutData();
    }
}
