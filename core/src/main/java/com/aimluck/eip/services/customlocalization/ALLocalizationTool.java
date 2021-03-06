/*
 * Aipo is a groupware program developed by Aimluck,Inc.
 * Copyright (C) 2004-2015 Aimluck,Inc.
 * http://www.aipo.com
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.aimluck.eip.services.customlocalization;

import java.util.Locale;
import java.util.MissingResourceException;

import org.apache.jetspeed.services.customlocalization.CustomLocalization;
import org.apache.jetspeed.services.customlocalization.CustomLocalizationTool;
import org.apache.jetspeed.services.logging.JetspeedLogFactoryService;
import org.apache.jetspeed.services.logging.JetspeedLogger;

/**
 *
 */
public class ALLocalizationTool extends CustomLocalizationTool {

  private static final JetspeedLogger logger = JetspeedLogFactoryService
    .getLogger(ALLocalizationTool.class.getName());

  @Override
  public String get(String key) {
    try {
      String s =
        CustomLocalization.getString(getBundleName(null), getLocale(), key);
      return s;
    } catch (MissingResourceException ignore) {
      try {
        String s =
          CustomLocalization.getString(
            getBundleName(null),
            Locale.JAPANESE,
            key);
        return s;
      } catch (MissingResourceException noKey) {
        logger.error("Exception", noKey);
      }
    }
    return null;
  }
}
