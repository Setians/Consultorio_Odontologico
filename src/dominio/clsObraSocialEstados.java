package dominio;

public class clsObraSocialEstados {
		private int OSE_Id;
		private String OSE_Detalle;
		
		public clsObraSocialEstados() {}

		public int getOSE_Id() {
			return OSE_Id;
		}

		public void setOSE_Id(int oSE_Id) {
			OSE_Id = oSE_Id;
		}

		public String getOSE_Detalle() {
			return OSE_Detalle;
		}

		public void setOSE_Detalle(String oSE_Detalle) {
			OSE_Detalle = oSE_Detalle;
		}

		@Override
		public String toString() {
			return "clsObraSocialEstados [OSE_Id=" + OSE_Id + ", OSE_Detalle=" + OSE_Detalle + "]";
		}

		public clsObraSocialEstados(int oSE_Id, String oSE_Detalle) {
			super();
			OSE_Id = oSE_Id;
			OSE_Detalle = oSE_Detalle;
		}
		
}
