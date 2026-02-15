
# ==========================================
# Environment Variables Setup - Spring Boot
# ==========================================

Write-Host "Configurando variables de entorno..."

setx DB_URL "jdbc:postgresql://ep-silent-moon-aixs1rqh-pooler.c-4.us-east-1.aws.neon.tech:5432/neondb?sslmode=require"
setx DB_USER "neondb_owner"
setx DB_PASS "npg_u4QXGO7qNpHf"

Write-Host "Variables configuradas correctamente."
Write-Host "IMPORTANTE: Cierra y vuelve a abrir la terminal o IntelliJ para que surtan efecto."
