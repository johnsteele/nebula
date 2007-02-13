/****************************************************************************
 * Copyright (c) 2006 Jeremy Dowdall
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jeremy Dowdall <jeremyd@aspencloud.com> - initial API and implementation
 *****************************************************************************/
package org.eclipse.swt.nebula.snippets.ctree;


import java.util.Date;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;

/*
 * Create a CTableTree with the Tree in the second column.
 *
 * For a list of all Nebula CTableTree example snippets see
 * http://www.eclipse.org/nebula/widgets/ctabletree/snippets.php
 */
public class TreeSnippet1 {
	public static void main (String [] args) {
		Display display = new Display ();
		Shell shell = new Shell (display);
		shell.setLayout(new FillLayout());

		Tree tree = new Tree(shell, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		
		tree.addMouseListener(new MouseAdapter() {
			public void mouseDown(MouseEvent e) {
				super.mouseDown(e);
			}
		});
		
//		tree.setTreeColumn(1);
		tree.setHeaderVisible(true);
//		tree.setLinesVisible(true);
		TreeColumn column1 = new TreeColumn(tree, SWT.LEFT);
		column1.setText("Column 1");
		column1.setWidth(200);
		column1.setMoveable(true);
		TreeColumn column2 = new TreeColumn(tree, SWT.CENTER);
		column2.setText("Column 2");
		column2.setWidth(200);
		column2.setMoveable(true);
		TreeColumn column3 = new TreeColumn(tree, SWT.RIGHT);
		column3.setText("Column 3");
		column3.setWidth(200);
		column3.setMoveable(true);

		Date start = new Date();
		for (int i = 0; i < 10000; i++) {
			TreeItem item = new TreeItem(tree, SWT.NONE);
			item.setText(new String[] { "item " + i, "abc", "defghi" });
//			for (int j = 0; j < 4; j++) {
//				TreeItem subItem = new TreeItem(item, SWT.NONE);
//				subItem.setText(new String[] { "subitem " + j, "jklmnop", "qrs" });
//				for (int k = 0; k < 4; k++) {
//					TreeItem subsubItem = new TreeItem(subItem, SWT.NONE);
//					subsubItem.setText(new String[] { "subsubitem " + k, "tuv", "wxyz" });
//				}
//			}
		}

		Date end = new Date();
		System.out.println("elapsed: " + (end.getTime() - start.getTime()));
		
		Point size = shell.computeSize(-1, -1);
		size.y = 400;
		Rectangle screen = display.getMonitors()[0].getBounds();
		shell.setBounds(
				(screen.width-size.x)/2,
				(screen.height-size.y)/2,
				size.x,
				size.y
		);
		shell.open ();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch ()) display.sleep ();
		}
		display.dispose ();
	}
} 