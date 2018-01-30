/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.knowledge.base.service.permission;

import com.liferay.knowledge.base.constants.KBConstants;
import com.liferay.knowledge.base.constants.KBPortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.BaseResourcePermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.ResourcePermissionChecker;

import org.osgi.service.component.annotations.Component;

/**
 * @author Peter Shin
 * @author Brian Wing Shun Chan
 */
@Component(
	property = {"resource.name=" + KBConstants.ADMIN_RESOURCE_NAME},
	service = ResourcePermissionChecker.class
)
public class AdminPermission extends BaseResourcePermissionChecker {

	public static final String RESOURCE_NAME = KBConstants.ADMIN_RESOURCE_NAME;

	public static void check(
			PermissionChecker permissionChecker, long groupId, String actionId)
		throws PortalException {

		if (!contains(permissionChecker, groupId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(
		PermissionChecker permissionChecker, long groupId, String actionId) {

		return contains(
			permissionChecker, KBConstants.ADMIN_RESOURCE_NAME,
			KBPortletKeys.KNOWLEDGE_BASE_ADMIN, groupId, actionId);
	}

	@Override
	public Boolean checkResource(
		PermissionChecker permissionChecker, long classPK, String actionId) {

		return contains(permissionChecker, classPK, actionId);
	}

}