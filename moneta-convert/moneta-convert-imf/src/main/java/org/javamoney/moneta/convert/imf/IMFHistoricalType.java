/*
  Copyright (c) 2012, 2015, Credit Suisse (Anatole Tresch), Werner Keil and others by the @author tag.

  Licensed under the Apache License, Version 2.0 (the "License"); you may not
  use this file except in compliance with the License. You may obtain a copy of
  the License at

  http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
  WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
  License for the specific language governing permissions and limitations under
  the License.
 */
package org.javamoney.moneta.convert.imf;

import java.time.YearMonth;
import java.util.Objects;

enum IMFHistoricalType {
	SDR_Currency("SDRCV"), Currency_SDR("CVSDR");

	private final String type;

	private static final String HOST = "https://www.imf.org/external/np/fin/data/rms_mth.aspx?SelectDate=%s&reportType=%s&tsvflag=Y";

	IMFHistoricalType(String type) {
		this.type = type;
	 }

	public String getType() {
		return type;
	}

	public String getUrl(YearMonth yearMonth) {
		return String.format(HOST, Objects.requireNonNull(yearMonth), type);
	}
}
