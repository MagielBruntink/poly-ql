/*******************************************************************************
 * Copyright (c) 2000, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.swt.internal.ole.win32;

public class IProvideClassInfo2 extends IProvideClassInfo
{
public IProvideClassInfo2(int /*long*/ address) {
	super(address);
}
public int GetGUID(int dwGuidKind, GUID pGUID) {
	return COM.VtblCall(4, address, dwGuidKind, pGUID);
}
}
