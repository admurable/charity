package charityapp.v1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Generator {

	public ArrayList<Charity> charityList;
	
	public ArrayList<Charity> generateCharities() {
		charityList = new ArrayList<Charity>();
		charityList.addAll(
				Arrays.asList(
					new International("Red Cross", "Bonnie McElveen-Hunter", 89.4f, "https://www.redcross.org", "+1 (800) 733-2767", false, 
							new HashSet<String>(Arrays.asList("Afghanistan",
							"Albania", "Algeria", "Andorra", "Angola", "Antigua and Barbuda", "Argentina",
							"Armenia", "Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh",
							"Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bhutan", "Bolivia", "Bosnia and Herzegovina",
							"Botswana", "Brazil", "Brunei", "Bulgaria", "Burkina Faso", "Burundi", "Cambodia", "Cameroon",
							"Canada", "Cape Verde", "Central Africa Republic", "Chad", "Chile", "China (Hong Kong and Macau)", 
							"Colombia", "Comoros", "Congo", "Democratic Republic of the Congo", "Cook Islands", "Costa Rica", 
							"Côte d'Ivoire", "Croatia", "Cuba", "Cyprus", "Czech Republic", "Denmark", "Dijibouti", "Dominica",
							"Dominican Republic", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Ethiopa",
							"Fiji", "Finland", "France", "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Greece", "Grenada",
							"Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti", "Honduras", "Hungary", "Iceland", "India",
							"Indonesia", "Iran", "Iraq", "Ireland", "Israel", "Italy", "Jamaica", "Japan", "Jordan", "Kazakhstan",
							"Kenya", "Kiribati", "North Korea", "South Korea", "Kuwait", "Krygyzstan", "Laos", "Latvia", "Lebanon",
							"Lesotho", "Liberia", "Libya", "Liechtenstein", "Lithuania", "Luxembourg", "Madasgascar", "Malawi",
							"Malaysia", "Maldives", "Mali", "Malta", "Marshal Islands", "Mauritania", "Mauritius", "Mexico",
							"Micronesia", "Moldova", "Monaco", "Mongolia", "Montenegro", "Morocco", "Mozambique", "Myanmar",
							"Namibia", "Nepal", "Netherlands", "New Zealand", "Nicaragua", "Niger", "Nigeria", "North Macedonia", "Norway",
							"Pakistan", "Palau", "Palestine", "Panama", "Papau New Guinea", "Paraguay", "Peru", "Philippines", "Poland",
							"Portugal", "Qatar", "Romania", "Russia", "Rwanda", "Saint Kitts and Nevis", "Saint Lucia", 
							"Saint Vincent and the Grenadines", "Samoa", "San Marino", "Sao Tome", "Saudi Arabia", "Senegal", "Serbia",
							"Seychelles", "Sierra Leone", "Singapore", "Slovakia", "Slovenia", "Solomon Islands", "Somalia", "South Africa",
							"South Sudan", "Spain", "Sri Lanka", "Sudan", "Suriname", "Swaziland", "Sweden", "Switzerland", "Tajikistan",
							"Tanzania", "Thailand", "Timor-Leste", "Togo", "Tonga", "Trinidad and Tobago", "Tunisia", "Turkey", "Turkmenistan",
							"Tuvalu", "Uganda", "Ukraine", "Uruguay", "United Arab Emirates", "United Kingdom", "United States of America",
							"Uzbekistan", "Vanuatu", "Venezuela", "Vietnam", "Yemen", "Zambia", "Zimbabwe")), 
						"France", 97000000),
					new National("Feeding America", "Claire Babineaux-Fontenot", 99, 
							"https://www.feedingamerica.org", "(800) 771-2303", false, 
							"United States of America", 200),
					new Local("Gloucester County Animal Shelter", "Bill Lombardi", 2, 
							"http://www.gloucestercountynj.gov/depts/a/shelter/", "8568812828", true,
							new HashSet<String>(Arrays.asList("Clayton")), 100)
				)
			);
		return charityList;
	}

}
