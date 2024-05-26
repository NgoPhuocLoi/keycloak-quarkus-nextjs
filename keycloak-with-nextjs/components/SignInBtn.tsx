import { signIn } from "@/auth";

export function SignInBtn() {
  return (
    <form
      action={async () => {
        "use server";
        await signIn("keycloak");
      }}
    >
      <button type="submit">Signin with Keycloak</button>
    </form>
  );
}
