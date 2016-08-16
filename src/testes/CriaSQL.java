package testes;

import java.lang.reflect.Field;

public class CriaSQL {

	public static String devolveSQLinsert(Object objeto) throws Exception {

		StringBuilder stringBuilder = new StringBuilder();
		StringBuilder stringBuilder2 = new StringBuilder();

		stringBuilder.append("insert into ");

		Class<?> classe = objeto.getClass();

		stringBuilder.append(classe.getSimpleName().toLowerCase() + " (");

		for (Field field : classe.getDeclaredFields()) {

			field.setAccessible(true);

			stringBuilder.append(field.getName() + ",");

			if (field.getType() == String.class) {

				stringBuilder2.append("'" + field.get(objeto) + "',");
			} else {
				stringBuilder2.append(field.get(objeto) + ",");
			}
		}
		stringBuilder.deleteCharAt(stringBuilder.length() - 1);
		stringBuilder.append(") values (");

		stringBuilder2.deleteCharAt(stringBuilder2.length() - 1);
		stringBuilder2.append(");");

		stringBuilder.append(stringBuilder2);

		return stringBuilder.toString();
	}

	public static String devolveSQLupdate(Object objeto) throws Exception {

		StringBuilder stringBuilder = new StringBuilder();
		StringBuilder stringBuilder2 = new StringBuilder();

		stringBuilder.append("update ");

		Class<?> classe = objeto.getClass();

		stringBuilder.append(classe.getSimpleName().toLowerCase());

		stringBuilder.append(" set ");

		for (Field f : classe.getDeclaredFields()) {

			f.setAccessible(true);

			if (f.getName() == "id") {

				stringBuilder2.append(" where id=" + f.get(objeto));
			} else {

				if (f.getType() == String.class) {

					stringBuilder.append(f.getName() + "='" + f.get(objeto) + "',");
				} else {
					stringBuilder.append(f.getName() + "=" + f.get(objeto) + ",");
				}
			}
		}
		stringBuilder.deleteCharAt(stringBuilder.length() - 1);

		stringBuilder.append(stringBuilder2);

		return stringBuilder.toString();
	}

}
