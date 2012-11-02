/*
 * Copyright 2008-2012, David Karnok 
 * The file is part of the Open Imperium Galactica project.
 * 
 * The code should be distributed under the LGPL license.
 * See http://www.gnu.org/licenses/lgpl.html for details.
 */

package hu.openig.editors.ce;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * The field represents a simple text attribute value. 
 * @author akarnokd, 2012.11.02.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface CETextAttribute {
	/** The attribute name. */
	String name();
}
